package com.nivora.ask.service;

import com.nivora.ask.adapter.AnswerAdapter;
import com.nivora.ask.dto.AnswerRequestDto;
import com.nivora.ask.dto.AnswerResponseDto;
import com.nivora.ask.model.Answer;
import com.nivora.ask.repo.AnswerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService implements IAnswerService {

    private final AnswerRepo answerRepo;

    @Override
    public Mono<AnswerResponseDto> createAnswer(AnswerRequestDto dto) {

        Answer answer = Answer.builder()
                .content(dto.getContent())
                .questionId(dto.getQuestionID())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return answerRepo.save(answer)
                .map(AnswerAdapter::toAnswerDTO);
    }

    @Override
    public Flux<AnswerResponseDto> getAnswerByID(String questionId) {

        return answerRepo.findByQuestionIdOrderByCreatedAtAsc(questionId)
                .map(AnswerAdapter::toAnswerDTO);

    }

}