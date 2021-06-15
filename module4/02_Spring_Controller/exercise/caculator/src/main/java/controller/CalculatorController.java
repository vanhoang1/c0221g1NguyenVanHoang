package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    @GetMapping("")
    public String showForm() {
        return "index";
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String calculator(@RequestParam double firstNum, @RequestParam double secondNum,@RequestParam String calculation, Model model) {
        String result = "";
        try {


            switch (calculation) {
                case "add":
                    result += firstNum + secondNum;
                    break;
                case "sub":
                    result += firstNum - secondNum;
                    break;
                case "mul":
                    result += firstNum * secondNum;
                    break;
                case "div":
                    if(secondNum==0) throw new Exception("error /0");
                    result += firstNum / secondNum;
                    break;
            }
        }catch (Exception e){
            result=e.getMessage();
        }
        model.addAttribute("result", result);
        return "index";
    }

}