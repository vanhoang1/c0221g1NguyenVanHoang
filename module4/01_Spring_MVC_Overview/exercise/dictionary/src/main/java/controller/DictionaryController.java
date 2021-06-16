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
public class DictionaryController {
   static Map<String,String> map = new HashMap<>();
   static {
       map.put("banana","chuối");
       map.put("cat","mèo");
       map.put("dog","chó");
   }
    @GetMapping("")
        public String showForm() {
            return "index";
        }
    @RequestMapping(path = "",method = RequestMethod.POST)
        public String convert(@RequestParam String eng, Model model) {
        String vn= map.get(eng);
        if(vn== null) vn="the word you entered is not in the dictionary";
        model.addAttribute("vn",vn);
        return "index";
    }

}