package com.example.backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String questionTitle;
    private String questionContent;
    private String questionAnswer;
    @Column(columnDefinition = "date")
    private String dateQuestion;
    @ManyToOne
    @JoinColumn(name = "question_type_id")
        private QuestionType questionType;
    @ManyToOne
    @JoinColumn(name = "user_create_id")
    private User userCreated;
    @ManyToOne
    @JoinColumn(name = "user_feed_back_id")
    private User userFeedBack;
    private boolean status = true;
    private boolean flag = true;
}
