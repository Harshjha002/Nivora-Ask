package com.nivora.ask.adapter;

import com.nivora.ask.dto.LikeResponseDto;
import com.nivora.ask.model.Like;

public class LikeAdapter {

    public static LikeResponseDto toLikeDTO(Like like){

        return LikeResponseDto.builder()
                .id(like.getId())
                .targetId(like.getTargetId())
                .targetType(like.getTargetType())
                .isLike(like.getIsLike())
                .createdAt(like.getCreatedAt())
                .build();

    }

}