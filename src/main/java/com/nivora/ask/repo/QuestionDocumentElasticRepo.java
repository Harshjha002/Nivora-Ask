package com.nivora.ask.repo;

import com.nivora.ask.model.QuestionElasticDocument;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

import reactor.core.publisher.Flux;



public interface QuestionDocumentElasticRepo
        extends ReactiveElasticsearchRepository<QuestionElasticDocument, String> {

    Flux<QuestionElasticDocument>
    findByTitleContainingOrContentContaining(String title, String content);
}