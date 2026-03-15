package com.nivora.ask.repo;

import com.nivora.ask.model.Like;
import com.nivora.ask.model.LikeTargetTypeEnum;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface LikeRepo extends ReactiveMongoRepository<Like,String> {

    Mono<Long> countByTargetIdAndTargetTypeAndIsLikeTrue(String targetId, LikeTargetTypeEnum targetType);

    Mono<Long> countByTargetIdAndTargetTypeAndIsLikeFalse(String targetId, LikeTargetTypeEnum targetType);

}