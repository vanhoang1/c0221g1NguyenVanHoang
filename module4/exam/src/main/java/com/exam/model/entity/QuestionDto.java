package com.exam.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    private Long id;
    @NotBlank
    @Size(min = 5, max = 100)
    private String title;
    @NotBlank
    @Size(min = 10, max = 500)
    private String question;
    private String answer;

    private LocalDate dateCreate;
    private Boolean status;

    private QuestionType questionType;
}
