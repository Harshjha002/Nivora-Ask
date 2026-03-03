package com.nivora.ask.service;

import com.nivora.ask.dto.AnswerRequestDto;
import com.nivora.ask.dto.AnswerResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAnswerService {


    public Mono<AnswerResponseDto> createAnswer(AnswerRequestDto answerRequestDto);
    public Flux<AnswerResponseDto> getAnswerByID(String id);

}
