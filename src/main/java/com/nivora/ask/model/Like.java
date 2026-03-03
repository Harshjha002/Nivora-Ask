package com.nivora.ask.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Likes")
public class Like {
    @Id
    private String id;

    private String targetId;

    private LikeTargetTypeEnum targetType;

    private Boolean  isLike;

    @CreatedDate
    private LocalDateTime createdAt;

}
