package com.example.demo;

import com.example.demo.document.Article;
import com.example.demo.repository.ArticleElasticRepository;
import com.example.demo.repository.ArticleMongoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class TestApp implements CommandLineRunner {

    private ArticleMongoRepository amr;
    private ArticleElasticRepository aer;

    public TestApp(ArticleMongoRepository amr, ArticleElasticRepository aer) {
        this.amr = amr;
        this.aer = aer;
    }


    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        amr.save(new Article("1", "Jawaharlal Nehru", "We make a tryst with destiny"));
        amr.save(new Article("2", "Martin Luther King", "I have a dream"));
        amr.save(new Article("3", "Barack Obama", "Yes, we can"));


        System.out.println("Articles found in MongoDB with findAll():");
        System.out.println("-----------------------------------------");
        Iterable<Article> articles = amr.findAll();
        articles.forEach(System.out::println);
        System.out.println();

        TimeUnit.SECONDS.sleep(5);


        System.out.println("Articles found in Elasticsearch with findAll():");
        System.out.println("-----------------------------------------------");
        articles = aer.findAll();
        articles.forEach(System.out::println);
        System.out.println();
    }

    //    public static void main(String[] args) {
    //        SpringApplication.run(TestingappApplication.class, args);
    //
    //        String authentication = "admin";
    //
    //        authentication.equalsIgnoreCase(Constants.ROLE_ADMIN);
    //    }
}
