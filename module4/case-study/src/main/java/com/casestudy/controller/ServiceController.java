package com.casestudy.controller;

import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.dto.CustomerDto;
import com.casestudy.model.entity.dto.ServiceDto;
import com.casestudy.model.entity.service.RentType;
import com.casestudy.model.entity.service.ServiceType;
import com.casestudy.model.entity.service.Services;
import com.casestudy.model.service.service.IService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/services")
public class ServiceController {
    private final IService cservice;
    @Autowired
    public ServiceController(IService service) {
        this.cservice = service;
    }

    @GetMapping("")
    public ModelAndView showListService(){
        return new ModelAndView("service/service-list","services",cservice.findAllNormal());
    }

    @GetMapping("/create")
    public ModelAndView createService(){
        return new ModelAndView("service/service-create","serviceDto",new ServiceDto());
    }
    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> getListServiceType(){
        return cservice.findAllServiceType();
    }
    @ModelAttribute("rentTypes")
    public Iterable<RentType> getListRentType(){
        return cservice.findAllRentType();
    }
    @PostMapping("/create")
    public String saveService(@ModelAttribute(name = "serviceDto") @Valid ServiceDto serviceDto, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "/service/service-create";
        }
        else {
            Services service = new Services();
            BeanUtils.copyProperties(serviceDto,service);
            this.cservice.save(service);
            return "redirect:/services/";
        }
    }
}
