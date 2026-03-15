package com.nivora.ask.controllers;

import com.nivora.ask.dto.AnswerRequestDto;
import com.nivora.ask.dto.AnswerResponseDto;
import com.nivora.ask.service.IAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final IAnswerService answerService;

    @PostMapping("/create")
    public Mono<AnswerResponseDto> createAnswer(
            @RequestBody AnswerRequestDto request){

        return answerService.createAnswer(request);
    }

    @GetMapping("/question/{questionId}")
    public Flux<AnswerResponseDto> getAnswersByQuestion(
            @PathVariable String questionId){

        return answerService.getAnswerByID(questionId);
    }

}