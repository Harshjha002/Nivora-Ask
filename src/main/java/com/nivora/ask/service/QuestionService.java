package com.nivora.ask.service;


import com.nivora.ask.adapter.QuestionAdapter;
import com.nivora.ask.dto.QuestionRequestDto;
import com.nivora.ask.dto.QuestionResponseDto;
import com.nivora.ask.model.Question;
import com.nivora.ask.repo.QuestionRepo;
import com.nivora.ask.utils.CursorUtils;
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
    public Flux<QuestionResponseDto> getAllQuestions(String cursor , int size) {
        System.out.println("I am going to hit questionRepo for all question with cursor :" + cursor + "and size :" + size);
        Pageable pageable = PageRequest.of(0 , size);

        if(!CursorUtils.isValidCursor(cursor)){
            System.out.println("Not Valid cursor");
            return questionRepo.findTop10ByOrderByCreatedAtAsc()
                    .take(size)
                    .map(QuestionAdapter::toQuestionDTO)
                    .doOnError(error -> System.out.println("Error fetching Questions:"+error))
                    .doOnComplete(() -> System.out.println("Question fetched Successfully"));

        }else {
            System.out.println("Valid cursor");
            LocalDateTime cursorTimeStamp = CursorUtils.parseCursor(cursor);
             return questionRepo.findByCreatedAtGreaterThanOrderByCreatedAtAsc(cursorTimeStamp , pageable)
                     .take(size)
                     .map(QuestionAdapter::toQuestionDTO)
                    .doOnError(error -> System.out.println("Error fetching questions: " + error))
                    .doOnComplete(() -> System.out.println("Question Fetched successfully"));
        }
    }


    //View Count
    @Override
    public Mono<QuestionResponseDto> getQuestionById(String id) {
        return questionRepo.findById(id)
                .map(QuestionAdapter::toQuestionDTO)
                .doOnError(err -> System.out.println("Error Fetching Data " + err))
                .doOnSuccess(response -> System.out.println("Question fetched successfully"));
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
