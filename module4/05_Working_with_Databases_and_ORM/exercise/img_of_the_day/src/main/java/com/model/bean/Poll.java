package com.model.bean;

import javax.persistence.*;

@Entity
@Table
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long evaluate;
    private String author;
    private String feedback;

    public Poll() {
    }

    public Poll(long evaluate, String author, String feedback) {
        this.evaluate = evaluate;
        this.author = author;
        this.feedback = feedback;
    }

    public Poll(long id, long evaluate, String author, String feedback) {
        this.id = id;
        this.evaluate = evaluate;
        this.author = author;
        this.feedback = feedback;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(long evaluate) {
        this.evaluate = evaluate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
