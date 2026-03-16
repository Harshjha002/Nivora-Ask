package com.nivora.ask.repo;

import com.nivora.ask.model.QuestionElasticDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface QuestionDocumentElasticRepo
        extends ElasticsearchRepository<QuestionElasticDocument, String> {

    List<QuestionElasticDocument>
    findByTitleContainingOrContentContaining(String title, String content);
}