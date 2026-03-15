package com.nivora.ask.service;

import com.nivora.ask.adapter.LikeAdapter;
import com.nivora.ask.dto.LikeRequestDto;
import com.nivora.ask.dto.LikeResponseDto;
import com.nivora.ask.model.Like;
import com.nivora.ask.model.LikeTargetTypeEnum;
import com.nivora.ask.repo.LikeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LikeService implements ILikeService {

    private final LikeRepo likeRepo;

    @Override
    public Mono<LikeResponseDto> createLike(LikeRequestDto dto) {

        Like like = Like.builder()
                .targetId(dto.getTargetId())
                .targetType(dto.getTargetType())
                .isLike(dto.getIsLike())
                .createdAt(LocalDateTime.now())
                .build();

        return likeRepo.save(like)
                .map(LikeAdapter::toLikeDTO);
    }

    @Override
    public Mono<LikeResponseDto> countLikesByTargetIdAndTargetType(String targetId, LikeTargetTypeEnum targetType) {

        return likeRepo.countByTargetIdAndTargetTypeAndIsLikeTrue(targetId, targetType)
                .map(count -> LikeResponseDto.builder()
                        .targetId(targetId)
                        .targetType(targetType)
                        .count(count)
                        .isLike(true)
                        .build());
    }

    @Override
    public Mono<LikeResponseDto> countDisLikesByTargetIdAndTargetType(String targetId, LikeTargetTypeEnum targetType) {

        return likeRepo.countByTargetIdAndTargetTypeAndIsLikeFalse(targetId, targetType)
                .map(count -> LikeResponseDto.builder()
                        .targetId(targetId)
                        .targetType(targetType)
                        .count(count)
                        .isLike(false)
                        .build());
    }

    @Override
    public Mono<LikeResponseDto> toggleLike(String targetId, LikeTargetTypeEnum targetType, Boolean isLike) {

        Like like = Like.builder()
                .targetId(targetId)
                .targetType(targetType)
                .isLike(isLike)
                .createdAt(LocalDateTime.now())
                .build();

        return likeRepo.save(like)
                .map(LikeAdapter::toLikeDTO);
    }
}