package com.nivora.ask.dto;

import com.nivora.ask.model.LikeTargetTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeResponseDto {

    private String id;

    private String targetId;

    private LikeTargetTypeEnum targetType;

    private Boolean isLike;

    private Long count;

    private LocalDateTime createdAt;
}