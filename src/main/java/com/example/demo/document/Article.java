package com.example.demo.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Document(indexName = "jcg")
public class Article {

    @Id
    private String id;

    private String title;
    private String body;
}