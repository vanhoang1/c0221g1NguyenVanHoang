package com.example.backend.model.dto;

import com.example.backend.model.entity.QuestionType;
import com.example.backend.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Long questionId;
    private String questionTitle;
    private String questionContent;
    private String questionAnswer;
    private String dateQuestion;
    private QuestionType questionType;
    private User userCreated;
    private User userFeedBack;
    private boolean status = true;
    private boolean flag = true;
}
