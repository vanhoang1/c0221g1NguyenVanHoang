package com.casestudy.controller;

import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.customer.CustomerType;
import com.casestudy.model.entity.dto.CustomerDto;
import com.casestudy.model.service.customer.ICustomerService;
import com.casestudy.util.WebUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@RequestMapping(path="/customers")
@Controller
public class CustomerController {
  private final  ICustomerService customerService;
    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public ModelAndView showListCustomer( Principal principal){
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        Iterable<Customer> customers = customerService.findAll();
        return new ModelAndView("customer/customer-list","loginedUser",loginedUser).addObject("customers",customers);
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/customer/customer-create","customerDto",new CustomerDto());
    }
    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute(name = "customerDto") @Valid CustomerDto customerDto, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "/customer/customer-create";
        }
        else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            this.customerService.save(customer);
            return "redirect:/customers/";
        }
    }

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> getListCustomerType(){
        return customerService.findAllCustomerType();
    }
}
