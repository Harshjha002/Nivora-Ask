package com.nivora.ask.service;


import com.nivora.ask.adapter.QuestionAdapter;
import com.nivora.ask.dto.QuestionRequestDto;
import com.nivora.ask.dto.QuestionResponseDto;
import com.nivora.ask.model.Question;
import com.nivora.ask.repo.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuestionService implements  IQuestionService {

    private final QuestionRepo questionRepo;


    //Create Question
    @Override
    public Mono<QuestionResponseDto> createQuestion(QuestionRequestDto questionRequestDto) {

        Question question = Question.builder()
                .title(questionRequestDto.getTitle())
                .content(questionRequestDto.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return questionRepo.save(question)
                .map(QuestionAdapter::toQuestionDTO)
                .doOnSuccess(response -> System.out.println("Question created successfully: " + response))
                .doOnError(error -> System.out.println("Error creating question: "+ error));


    }

    @Override
    public Flux<QuestionResponseDto> getAllQuestions() {
        return null;
    }

    @Override
    public Mono<QuestionResponseDto> getQuestionById(String id) {
        return null;
    }

    @Override
    public Mono<Void> deleteQuestionById(String id) {
        return null;
    }

    @Override
    public Flux<QuestionResponseDto> searchQuestions(String query, int page, int size) {

        Pageable pageable = PageRequest.of(page,size);

        return questionRepo.findByTitleOrContentContainingIgnoreCase(query , pageable)
                .map(QuestionAdapter::toQuestionDTO)
                .doOnError(error -> System.out.println("Error Searching Question: "+ error))
                .doOnComplete(() -> System.out.println("Question Search Completed"));
    }

    @Override
    public Flux<QuestionResponseDto> getQuestionsByTag(String tag, int page, int size) {
        return null;
    }
}
