package com.controller;

import com.model.service.poll.IPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PollController {
    private final IPollService pollService;

    @Autowired
    public PollController(IPollService pollService) {
        this.pollService = pollService;
    }
    @GetMapping(path = "")
    public ModelAndView showList() {
        return new ModelAndView("list","pollList",pollService.findAll());
    }

}
