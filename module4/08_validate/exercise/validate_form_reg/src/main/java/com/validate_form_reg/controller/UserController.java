package com.validate_form_reg.controller;

import com.validate_form_reg.model.entity.User;
import com.validate_form_reg.model.service.IUserService;
import com.validate_form_reg.model.validate.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
private final IUserService userService;
@Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @GetMapping("")
    public ModelAndView showFormCreate(){
        return  new ModelAndView("index","user",new UserDto());
    }
    @PostMapping("")
    public String save(@Valid @ModelAttribute("user")UserDto userDto , BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "index";
        }else {
            User user= new User();
            BeanUtils.copyProperties(userDto,user);
            userService.save(user);
            model.addAttribute("user", user);
            return "/result";
        }

    }
}
