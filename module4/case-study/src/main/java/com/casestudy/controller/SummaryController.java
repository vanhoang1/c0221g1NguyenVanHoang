package com.casestudy.controller;

import com.casestudy.model.entity.customer.CustomerView;
import com.casestudy.model.service.summary.ICustomerViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer-view")
public class SummaryController {
    private final ICustomerViewService customerViewService;
    @Autowired
    public SummaryController(ICustomerViewService customerViewService) {
        this.customerViewService = customerViewService;
    }

    @GetMapping("")
    public ModelAndView showListEmployee(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value="keyword",defaultValue = "",required = false) String keyword){
        if(keyword== null) keyword="";
        Page<CustomerView> customerViews = customerViewService.findAll(pageable,keyword);
        return new ModelAndView("summary/customer-view","customerViews",customerViews).addObject("keyword",keyword);
    }

}
