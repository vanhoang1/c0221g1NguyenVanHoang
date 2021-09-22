package com.example.backend.controller;

import com.example.backend.model.dto.QuestionDto;
import com.example.backend.model.dto.UDto;
import com.example.backend.model.entity.Question;
import com.example.backend.model.entity.QuestionType;
import com.example.backend.model.entity.User;
import com.example.backend.model.service.IQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("api/questions")
public class RestQuestionController {
    private final IQuestionService questionService;

    public RestQuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Page<Question>> getAllQuestions(@RequestParam Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        Page<Question> questions = this.questionService.getAllQuestions(pageable);

        if (questions.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping(value = "/questionType")
    public ResponseEntity<List<QuestionType>> getAllQuestionsTypes() {
        List<QuestionType> questions = this.questionService.getAllQuestionsTypes();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable Long id) {
        Optional<Question> question = this.questionService.findById(id);
        return new ResponseEntity<>(question.get(), HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionDto questionDto) {
        Question question = new Question();
        BeanUtils.copyProperties(questionDto, question);
        this.questionService.create(question);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody QuestionDto questionDto) {
        Question question = new Question();
        BeanUtils.copyProperties(questionDto, question);
        this.questionService.update(question);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Question> del(@PathVariable Long id) {
        this.questionService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> login(@RequestBody UDto uDto) {
        User u = new User();
        BeanUtils.copyProperties(uDto, u);
        Optional<User> user = this.questionService.login(u);
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }
}
