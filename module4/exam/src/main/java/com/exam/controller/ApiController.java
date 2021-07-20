package com.exam.controller;

import com.exam.model.entity.Question;
import com.exam.model.service.IQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController

public class ApiController {
    private final IQuestionService questionService;

    @Autowired
    public ApiController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions/edit/{id}")
    public ResponseEntity<Question> showFormEdit(@PathVariable Long id, Model model){
        Optional<Question> question = this.questionService.findById(id);

        if(question.isPresent()){

            return new ResponseEntity<Question>(question.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
