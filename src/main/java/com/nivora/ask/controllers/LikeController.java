package com.nivora.ask.controllers;

import com.nivora.ask.dto.LikeRequestDto;
import com.nivora.ask.dto.LikeResponseDto;
import com.nivora.ask.model.LikeTargetTypeEnum;
import com.nivora.ask.service.ILikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/likes")
@RequiredArgsConstructor
public class LikeController {

    private final ILikeService likeService;

    // Create Like
    @PostMapping
    public Mono<LikeResponseDto> createLike(
            @RequestBody LikeRequestDto request) {

        return likeService.createLike(request);
    }

    // Count Likes
    @GetMapping("/likes")
    public Mono<LikeResponseDto> countLikes(
            @RequestParam String targetId,
            @RequestParam LikeTargetTypeEnum targetType) {

        return likeService.countLikesByTargetIdAndTargetType(targetId, targetType);
    }

    // Count Dislikes
    @GetMapping("/dislikes")
    public Mono<LikeResponseDto> countDislikes(
            @RequestParam String targetId,
            @RequestParam LikeTargetTypeEnum targetType) {

        return likeService.countDisLikesByTargetIdAndTargetType(targetId, targetType);
    }

    // Toggle Like
    @PutMapping("/toggle")
    public Mono<LikeResponseDto> toggleLike(
            @RequestParam String targetId,
            @RequestParam LikeTargetTypeEnum targetType,
            @RequestParam Boolean isLike) {

        return likeService.toggleLike(targetId, targetType, isLike);
    }
}