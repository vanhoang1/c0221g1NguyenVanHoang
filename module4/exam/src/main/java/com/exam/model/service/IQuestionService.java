package com.exam.model.service;

import com.exam.model.entity.Question;
import com.exam.model.entity.QuestionType;

public interface IQuestionService extends IGeneralService<Question> {
  Iterable<QuestionType>  findAllQuestionType();
}
