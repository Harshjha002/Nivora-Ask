package com.nivora.ask.dto;

import com.nivora.ask.model.LikeTargetTypeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeRequestDto {

    @NotNull(message = "Target ID is required")
    private String targetId;

    @NotNull(message = "Target type is required")
    private LikeTargetTypeEnum targetType;

    @NotNull(message = "Like value is required")
    private Boolean isLike;
}