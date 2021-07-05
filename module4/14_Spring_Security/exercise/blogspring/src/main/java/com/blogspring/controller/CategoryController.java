package com.blogspring.controller;

import com.blogspring.model.entity.Category;
import com.blogspring.model.service.category.ICategoryService;
import com.blogspring.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

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
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
}
