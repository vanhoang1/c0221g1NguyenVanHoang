package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ConverterController {
    @GetMapping("")
        public String showForm() {
            return "index";
        }
    @RequestMapping(path = "",method = RequestMethod.POST)
        public String convert(@RequestParam int usd, Model model) {
        model.addAttribute("vnd", usd*23000);
        return "index";
    }

}