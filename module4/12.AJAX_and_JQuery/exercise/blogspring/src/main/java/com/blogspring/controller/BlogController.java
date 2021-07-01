package com.blogspring.controller;

import com.blogspring.model.entity.Blog;
import com.blogspring.model.entity.Category;
import com.blogspring.model.service.blog.IBlogService;
import com.blogspring.model.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
public class BlogController {

    private final IBlogService blogService;

    private  final ICategoryService categoryService;

    @Autowired
    public BlogController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
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
    @ModelAttribute("categorys")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }
    @GetMapping("/fragments")
    public String getHome() {
        return "fragments";
    }
    @GetMapping( path = "")
    public ModelAndView showBlog(@PageableDefault(value = 3) Pageable pageable){
        return new ModelAndView("/blog/index","blogList",blogService.findAll(pageable));
    }
    @GetMapping( path = "/sort")
    public ModelAndView sortByDate(@PageableDefault(value = 5,sort = {"createDate"}, direction = Sort.Direction.DESC ) Pageable pageable){

        return new ModelAndView("/blog/index","blogList",blogService.findAll(pageable));
    }
}
