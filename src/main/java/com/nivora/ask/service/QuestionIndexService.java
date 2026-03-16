package com.nivora.ask.service;

import com.nivora.ask.model.Question;
import com.nivora.ask.model.QuestionElasticDocument;
import com.nivora.ask.repo.QuestionDocumentElasticRepo;
import org.springframework.stereotype.Service;


@Service
public class QuestionIndexService implements IQuestionIndexService {

    private final QuestionDocumentElasticRepo repo;

    public QuestionIndexService(QuestionDocumentElasticRepo repo) {
        this.repo = repo;
    }

    @Override
    public void createQuestionIndex(Question question) {

        QuestionElasticDocument doc = QuestionElasticDocument.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .build();

        repo.save(doc);
    }
}