package com.blogspring.controller;

import com.blogspring.model.entity.Blog;
import com.blogspring.model.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class BlogController {

    private final IBlogService blogService;

    @Autowired
    public BlogController(IBlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping(path = "")
    public ModelAndView showBlog(){
        return new ModelAndView("/blog/index","blogList",blogService.findAll());
    }
    @GetMapping(path = "/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/blog/create-or-edit","blog",new Blog());
    }

    @PostMapping(path = "/save")
    public String  save(Blog blog){
        blog.setCreateDate(LocalDate.now());
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping(path = "edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id ){
        return new ModelAndView("/blog/create-or-edit","blog", blogService.findById(id).orElse(new Blog()));
    }
    @GetMapping(path = "delete/{id}")
    public String delete(@PathVariable Long id ){
        blogService.remove(id);
        return "redirect:/";
    }
    @GetMapping(path = "view/{id}")
    public ModelAndView showView(@PathVariable Long id ){
        return new ModelAndView("/blog/view","blog", blogService.findById(id).orElse(new Blog()));
    }
}
