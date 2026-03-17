package com.nivora.ask.controllers;

import com.nivora.ask.dto.QuestionRequestDto;
import com.nivora.ask.dto.QuestionResponseDto;
import com.nivora.ask.model.QuestionElasticDocument;
import com.nivora.ask.service.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private final IQuestionService questionService;

    // Create a new question
    @PostMapping("/create")
    public Mono<QuestionResponseDto> createQuestion(
            @RequestBody QuestionRequestDto request) {

        return questionService.createQuestion(request);
    }

    // Get all questions
    @GetMapping
    public Flux<QuestionResponseDto> getAllQuestions(
            @RequestParam(required = false) String cursor,
            @RequestParam(defaultValue = "10") int size

    ) {
        System.out.println("All Question api hit");

        return questionService.getAllQuestions(cursor,size);
    }

    // Get question by ID
    @GetMapping("/{id}")
    public Mono<QuestionResponseDto> getQuestionById(
            @PathVariable String id) {

        return questionService.getQuestionById(id);
    }

    // Delete question by ID
    @DeleteMapping("/{id}")
    public Mono<Void> deleteQuestionById(
            @PathVariable String id) {

        return questionService.deleteQuestionById(id);
    }

    // Search questions (pagination supported)
    @GetMapping("/search")
    public Flux<QuestionResponseDto> searchQuestions(
            @RequestParam String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return questionService.searchQuestions(query, page, size);
    }

    // Get questions by tag (pagination supported)
    @GetMapping("/tag/{tag}")
    public Flux<QuestionResponseDto> getQuestionsByTag(
            @PathVariable String tag,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return questionService.getQuestionsByTag(tag, page, size);
    }

    @GetMapping("/elasticsearch")
    public Flux<QuestionElasticDocument> searchByElasticsearch(
            @RequestParam String query) {

        return questionService.searchQuestionByElasticsearch(query);
    }
}