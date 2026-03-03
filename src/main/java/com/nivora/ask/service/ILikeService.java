package com.nivora.ask.service;

import com.nivora.ask.dto.LikeRequestDto;
import com.nivora.ask.dto.LikeResponseDto;
import com.nivora.ask.model.LikeTargetTypeEnum;
import reactor.core.publisher.Mono;

public interface ILikeService {

    Mono<LikeRequestDto> createLike(LikeRequestDto likeRequestDto);

    Mono<LikeResponseDto> countLikesByTargetIdAndTargetType(String targetId , LikeTargetTypeEnum targetType);

    Mono<LikeResponseDto> countDisLikesByTargetIdAndTargetType(String targetId , LikeTargetTypeEnum targetType);

    Mono<LikeResponseDto> toggleLike(String targetId , LikeTargetTypeEnum targetType , Boolean islike);
}
