package com.nivora.ask.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "questions")
public class QuestionElasticDocument {

    @Id
    private String id;

    private String title;

    private String content;
}