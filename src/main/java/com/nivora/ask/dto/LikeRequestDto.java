package com.nivora.ask.dto;

import com.nivora.ask.model.LikeTargetTypeEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeRequestDto {

    @NotBlank(message = "Target ID is required")
    private  String targetId;

    @NotBlank(message = "Target Type is required")
    private LikeTargetTypeEnum targetType;

    @NotBlank(message = "Is Like is required")
    private Boolean isLike;
}
