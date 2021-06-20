package com.controller;

import com.model.bean.Poll;
import com.model.service.poll.IPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class PollController {
    private final IPollService pollService;

    @Autowired
    public PollController(IPollService pollService) {
        this.pollService = pollService;
    }
    @GetMapping(path = "")
    public String showList(Model model) {
       model.addAttribute("pollList",pollService.findAllOnCurrentDate());
       model.addAttribute("poll",new Poll());
        return"index";
    }
    @PostMapping(path = "/addComment")
    public String addComment(Poll poll, RedirectAttributes redirectAttributes){
        poll.setDateCreate(LocalDate.now());
        pollService.add(poll);
        redirectAttributes.addFlashAttribute("Comment successfully !");
        return "redirect:/";
    }
    @GetMapping(path = "/like/{id}")
    public  String like(@PathVariable long id){
        pollService.like(id);
        return "redirect:/";
    }
}
