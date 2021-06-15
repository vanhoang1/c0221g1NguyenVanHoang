package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SandwichController {

    @GetMapping("")
        public String showForm() {
            return "index";
        }
    @RequestMapping(path = "",method = RequestMethod.POST)
        public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("list",condiment);
        return "index";
    }

}