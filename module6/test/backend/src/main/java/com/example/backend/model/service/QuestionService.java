package com.example.backend.model.service;

import com.example.backend.model.entity.Question;
import com.example.backend.model.entity.QuestionType;
import com.example.backend.model.repository.IQuestionRepository;
import com.example.backend.model.repository.IQuestionTypeRepository;
import com.example.backend.model.repository.IUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class QuestionService implements IQuestionService {
    private final IQuestionRepository questionRepository;
    private final IQuestionTypeRepository questionTypeRepository;
    private final IUserRepository userRepository;

    public QuestionService(IQuestionRepository questionRepository, IQuestionTypeRepository questionTypeRepository, IUserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.questionTypeRepository = questionTypeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<QuestionType> findAllQuestionType() {
        return questionTypeRepository.findAll();
    }

    @Override
    public Page<Question> getAllQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public List<QuestionType> getAllQuestionsTypes() {
        return this.questionTypeRepository.findAll();
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
    public void create(Question question) {
        this.questionRepository.create(question.getDateQuestion(),true,null,question.getQuestionContent(), question.getQuestionTitle(), true ,question.getQuestionType().getQuestionTypeId(),question.getUserCreated().getUserId(),null);
    }

    @Override
    public void update(Question question) {
        this.questionRepository.save(question);
    }

    @Override
    public void remove(Long id) {
        this.questionRepository.deleteById(id);
    }
}
