package com.nivora.ask.service;

import com.nivora.ask.dto.QuestionRequestDto;
import com.nivora.ask.dto.QuestionResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuestionService {

    // Create question
    Mono<QuestionResponseDto> createQuestion(QuestionRequestDto request);

    // Get all questions
    Flux<QuestionResponseDto> getAllQuestions();

    // Get question by ID
    Mono<QuestionResponseDto> getQuestionById(String id);

    // Delete question by ID
    Mono<Void> deleteQuestionById(String id);

    // Search questions with pagination
    Flux<QuestionResponseDto> searchQuestions(String query, int page, int size);

    // Get questions by tag with pagination
    Flux<QuestionResponseDto> getQuestionsByTag(String tag, int page, int size);
}