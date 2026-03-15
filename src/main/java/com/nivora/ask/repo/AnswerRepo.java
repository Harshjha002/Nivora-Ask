package com.nivora.ask.repo;


import com.nivora.ask.model.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AnswerRepo extends ReactiveMongoRepository<Answer,String> {
    Flux<Answer> findByQuestionIdOrderByCreatedAtAsc(String questionId);
}
