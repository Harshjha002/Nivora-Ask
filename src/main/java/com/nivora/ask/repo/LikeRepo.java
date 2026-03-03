package com.nivora.ask.repo;

import com.nivora.ask.model.Answer;
import com.nivora.ask.model.Like;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LikeRepo extends ReactiveMongoRepository<Like,String> {

}
