package com.exam.controller;

import com.exam.model.entity.Question;
import com.exam.model.entity.QuestionDto;
import com.exam.model.entity.QuestionType;
import com.exam.model.service.IQuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    private final IQuestionService questionService;

    @Autowired
    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("")
    public ModelAndView showListCustomer(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value="keyword",defaultValue = "",required = false) String keyword){
        if(keyword== null) keyword="";
        Page<Question> questions = questionService.findAllWithKeyWord(pageable,keyword);
        return new ModelAndView("/question/question-list","questions",questions).addObject("keyword",keyword);
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/question/question-create","questionDto",new QuestionDto());
    }
    @PostMapping("/create")
    public String saveQuestion(@ModelAttribute(name = "questionDto") @Valid QuestionDto questionDto, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "/question/question-create";
        }
        else {
            Question question = new Question();
            BeanUtils.copyProperties(questionDto,question);
            question.setDateCreate(LocalDate.now());
            this.questionService.save(question);
            return "redirect:/questions/";
        }
    }
    @GetMapping("/del/{id}")
    public String deleteQuestion(@PathVariable Long id, RedirectAttributes redirectAttributes){
        Optional<Question> question = this.questionService.findById(id);

        if(question.isPresent()){
            this.questionService.remove(id);
            redirectAttributes.addFlashAttribute("message","delete successfully !");
        }
        return "redirect:/questions/";
    }
    @ModelAttribute("questionTypes")
    public Iterable<QuestionType> getListQuestionType(){
        return questionService.findAllQuestionType();
    }
}
