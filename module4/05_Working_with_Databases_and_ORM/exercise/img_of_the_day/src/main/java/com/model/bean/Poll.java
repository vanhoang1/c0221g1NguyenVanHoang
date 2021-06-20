package com.model.bean;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "poll")
@Data
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "evaluate")
    private long evaluate;
    @Column(name = "author")
    private String author;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "date_created")
    private LocalDate dateCreate;
    @Column(name = "count_like")
    private int countLike;
}
