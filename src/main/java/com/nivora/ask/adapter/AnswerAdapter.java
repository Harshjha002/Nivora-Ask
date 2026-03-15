package com.nivora.ask.adapter;

import com.nivora.ask.dto.AnswerResponseDto;
import com.nivora.ask.model.Answer;

public class AnswerAdapter {

    public static AnswerResponseDto toAnswerDTO(Answer answer){

        return AnswerResponseDto.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .createdAt(answer.getCreatedAt())
                .build();

    }

}