package com.blogspring.controller;

import com.blogspring.model.entity.Category;
import com.blogspring.model.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {
    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping(path = "")
    public ModelAndView showBlog(){
        return new ModelAndView("category/index","categoryList",categoryService.findAll());
    }
    @GetMapping(path = "/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("category/create-or-edit","category",new Category());
    }
    @PostMapping(path = "/save")
    public String  save(Category category){
        categoryService.save(category);
        return "redirect:/category/";
    }
    @GetMapping(path = "edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id ){
        return new ModelAndView("/category/create-or-edit","category", categoryService.findById(id).orElse(new Category()));
    }
    @GetMapping(path = "delete/{id}")
    public String delete(@PathVariable Long id ){
        categoryService.remove(id);
        return "redirect:/category/";
    }
    @GetMapping(path = "view/{id}")
    public ModelAndView showView(@PathVariable Long id ){
        return new ModelAndView("/category/view","category", categoryService.findById(id).orElse(new Category()));
    }
}
