package com.exam.model.service;

import com.exam.model.entity.Question;
import com.exam.model.entity.QuestionType;
import com.exam.model.repository.IQuestionRepository;
import com.exam.model.repository.IQuestionTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class QuestionService implements IQuestionService {
    private final IQuestionRepository questionRepository;
    private final IQuestionTypeRepository questionTypeRepository;

    public QuestionService(IQuestionRepository questionRepository, IQuestionTypeRepository questionTypeRepository) {
        this.questionRepository = questionRepository;
        this.questionTypeRepository = questionTypeRepository;
    }

    @Override
    public Iterable<QuestionType> findAllQuestionType() {
        return questionTypeRepository.findAll();
    }

    @Override
    public Page<Question> findAllWithKeyWord(Pageable pageable, String keyword) {
        return questionRepository.findAllWithKeyWord(pageable, '%'+keyword+'%');
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Iterable<Question> findAllNormal() {
        return null;
    }

    @Override
    public void save(Question question) {
        this.questionRepository.save(question);
    }

    @Override
    public void remove(Long id) {
        this.questionRepository.deleteById(id);
    }
}
