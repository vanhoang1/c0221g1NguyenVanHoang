package com.exam.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    private String title;
    private String question;
    private String answer;
    private  LocalDate dateCreate;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "id_question_type")
    private QuestionType questionType;


}
