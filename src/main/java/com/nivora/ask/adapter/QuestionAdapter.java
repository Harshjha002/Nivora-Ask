package com.nivora.ask.adapter;

import com.nivora.ask.dto.QuestionResponseDto;
import com.nivora.ask.model.Question;

public class QuestionAdapter {
    public  static QuestionResponseDto toQuestionDTO(Question question){
        return QuestionResponseDto.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .createdAt(question.getCreatedAt())
                .build();
    }
}
