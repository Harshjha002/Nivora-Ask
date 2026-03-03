package com.nivora.ask.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerRequestDto {


    @NotBlank(message = "Title is required")
    @Size(min = 10 , max = 100, message = "Title must be between 10 to 100 characters")
    private  String Content;

    private  String questionID;
}
