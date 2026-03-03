package com.nivora.ask.repo;


import com.nivora.ask.model.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends ReactiveMongoRepository<Answer,String> {

}
