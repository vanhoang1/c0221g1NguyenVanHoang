package com.controller;

import com.model.bean.Setting;
import com.model.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    private final ISettingService settingService;

    @Autowired
    public SettingController(ISettingService settingService) {
        this.settingService = settingService;
    }



    @GetMapping(value = {"","/edit"})
    public ModelAndView showIndex(){
        return new ModelAndView("index","setting",settingService .findSetting());
    }
    @PostMapping(value = "/configSetting")
    public ModelAndView saveSetting(@ModelAttribute("setting")Setting setting){
        settingService.saveSetting(setting);
        return new ModelAndView("showSetting","setting",setting);

    }

}
