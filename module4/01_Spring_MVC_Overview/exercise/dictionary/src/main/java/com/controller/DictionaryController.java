package com.controller;

import com.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DictionaryController {
    private  final   IDictionaryService dictionaryService;
    @Autowired
    public DictionaryController(IDictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }
    @GetMapping("")
        public String showForm() {
            return "index";
        }
    @PostMapping(path = "")
        public String convert(@RequestParam String eng, Model model) {
        String vn= dictionaryService.getMeaning(eng);
        model.addAttribute("vn",vn);
        return "index";
    }

}