package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping(value = "")
    public String showForm(){
        return "index";
    }
    @PostMapping("")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condiments",condiment);
        return "index";
    }
}
