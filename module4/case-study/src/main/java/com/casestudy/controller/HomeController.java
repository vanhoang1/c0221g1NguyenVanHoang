package com.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("message","logout success fully");
        return "common/loginPage";
    }
    @GetMapping("/403")
    public String accessDenied(Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message","Access Denied");
        return "redirect:/";
    }
    @GetMapping("/loginSuccessful")
    public String login(Model model) {
        model.addAttribute("message","logout success fully");
        return "common/index";
    }
}
