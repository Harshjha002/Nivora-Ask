package com.nivora.ask.repo;


import com.nivora.ask.model.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface QuestionRepo extends ReactiveMongoRepository<Question,String> {
    @Query("{'$or':  [{'title' : { $regex: ?0,$options: 'i'} } , {'content' :  { $regex: ?0,$options: 'i'} }]}")
    Flux<Question> findByTitleOrContentContainingIgnoreCase(String query, Pageable pageable);
}
