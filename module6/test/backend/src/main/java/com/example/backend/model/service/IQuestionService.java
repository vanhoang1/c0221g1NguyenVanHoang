package com.example.backend.model.service;

import com.example.backend.model.entity.Question;
import com.example.backend.model.entity.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IQuestionService extends IGeneralService<Question> {
  Iterable<QuestionType>  findAllQuestionType();

  Page<Question> getAllQuestions(Pageable pageable);

  List<QuestionType> getAllQuestionsTypes();
}
