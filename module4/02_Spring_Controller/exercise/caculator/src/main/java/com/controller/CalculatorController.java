package com.controller;

import com.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {
 private final ICalculatorService calculatorService;
    @Autowired
    public CalculatorController(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("")
    public String showForm() {
        return "index";
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String calculator(@RequestParam double firstNum, @RequestParam double secondNum,@RequestParam String calculation, Model model) {
        model.addAttribute("result", calculatorService.calculation(firstNum,secondNum,calculation));
        return "index";
    }

}