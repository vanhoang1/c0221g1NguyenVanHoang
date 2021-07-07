package com.casestudy.controller;

import com.casestudy.model.entity.contract.Contract;
import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.dto.ContractDto;
import com.casestudy.model.entity.dto.ServiceDto;
import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.entity.service.Services;
import com.casestudy.model.service.contract.IContractService;
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
@RequestMapping("contracts")
public class ContractController {
    private final IContractService contractService;

    @Autowired
    public ContractController(IContractService contractService) {
        this.contractService = contractService;
    }

    @ModelAttribute("customers")
    public Iterable<Customer> getListCustomer() {
        return contractService.findAllCustomer();
    }

    @ModelAttribute("employees")
    public Iterable<Employee> getListEmployee() {
        return contractService.findAllEmployee();
    }

    @ModelAttribute("services")
    public Iterable<Services> getListServices() {
        return contractService.findAllService();
    }

    @GetMapping("")
    public ModelAndView showListContract(){
        return new ModelAndView("contract/contract-list","contracts",contractService.findAllNormal());
    }
    @GetMapping("/create")
    public ModelAndView createContract(){
        return new ModelAndView("contract/contract-create","contractDto",new ContractDto());
    }
    @PostMapping("/create")
    public String saveContract(@ModelAttribute(name = "contractDto") @Valid ContractDto contractDto, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "/contract/contract-create";
        }
        else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            this.contractService.save(contract);
            return "redirect:/contracts/";
        }
    }
}
