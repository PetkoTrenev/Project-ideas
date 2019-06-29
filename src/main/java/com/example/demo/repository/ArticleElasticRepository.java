package com.example.demo.repository;

import com.example.demo.document.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleElasticRepository extends ElasticsearchRepository<Article, String> {
}
