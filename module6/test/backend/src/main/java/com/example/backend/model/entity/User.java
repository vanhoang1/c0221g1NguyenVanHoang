package com.example.backend.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    @OneToMany(mappedBy = "userCreated",cascade = {CascadeType.ALL})
    @JsonBackReference(value = "userCreatedJs")
    List<Question> questionsCreated;
    @OneToMany(mappedBy = "userFeedBack",cascade = {CascadeType.ALL})
    @JsonBackReference(value = "userFeedBackJs")
    List<Question> questionsFeedBack;
}
