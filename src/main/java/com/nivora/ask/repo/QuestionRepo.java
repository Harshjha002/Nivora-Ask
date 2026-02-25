package com.nivora.ask.repo;


import com.nivora.ask.model.Question;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends ReactiveMongoRepository<Question,String> {

}
