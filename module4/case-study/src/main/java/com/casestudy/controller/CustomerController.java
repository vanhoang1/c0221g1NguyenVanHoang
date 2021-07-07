package com.casestudy.controller;

import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.customer.CustomerType;
import com.casestudy.model.entity.dto.CustomerDto;
import com.casestudy.model.service.customer.ICustomerService;
import com.casestudy.util.WebUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@RequestMapping(path="/customers")
@Controller
public class CustomerController {
  private final  ICustomerService customerService;
    @Autowired
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public ModelAndView showListCustomer(@PageableDefault(value = 5)Pageable pageable,@RequestParam(value="keyword",defaultValue = "",required = false) String keyword){
        if(keyword== null) keyword="";
        Page<Customer> customers = customerService.findAll(pageable,keyword);
        return new ModelAndView("customer/customer-list","customers",customers).addObject("keyword",keyword);
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
            customer.setFlag(true);
            this.customerService.save(customer);
            return "redirect:/customers/";
        }
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id,Model model){
        Optional<Customer> customer = this.customerService.findById(id);

        if(customer.isPresent()){
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer.get(),customerDto);
            model.addAttribute("customerDto",customerDto);
            return "/customer/customer-edit";
        }
        else {
            return "redirect:/customers/";
        }
    }
    @PostMapping("/edit/{id}")
    public String save(@PathVariable Long id,@ModelAttribute("customerDto") @Valid CustomerDto customerDto , BindingResult bindingResult){

        if(bindingResult.hasFieldErrors()){
            return "/customer/customer-edit";
        }
        else {
            Optional<Customer> customer = this.customerService.findById(id);
           if(customer.isPresent()) {
               BeanUtils.copyProperties(customerDto, customer.get());
               this.customerService.save(customer.get());
           }
            return "redirect:/customers/";
        }
    }
    @GetMapping("/del/{id}")
    public String deleteCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes){
        Optional<Customer> customer = this.customerService.findById(id);

        if(customer.isPresent()){
           this.customerService.remove(id);
           redirectAttributes.addFlashAttribute("message","delete successfully !");
        }
        return "redirect:/customers/";
    }
    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> getListCustomerType(){
        return customerService.findAllCustomerType();
    }
}
