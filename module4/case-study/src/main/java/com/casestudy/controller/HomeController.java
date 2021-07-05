package com.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(path = "")
    public String goHomePage(){
        return "common/index";
    }
    @GetMapping("/login")
    public String loginPage(Model model) {
        return "common/loginPage";
    }
    @GetMapping("/logoutSuccessful")
    public String logout(Model model) {
        return "common/loginPage";
    }
}
