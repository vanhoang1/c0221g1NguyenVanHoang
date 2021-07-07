package com.casestudy.controller;

import com.casestudy.model.entity.contract.AttachService;
import com.casestudy.model.entity.contract.Contract;
import com.casestudy.model.entity.contract.ContractDetail;
import com.casestudy.model.entity.dto.ContractDetailDto;
import com.casestudy.model.entity.dto.ContractDto;
import com.casestudy.model.service.contractDetail.IContractDetailService;
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
@RequestMapping("contract-detail")
public class ContractDetailController {
    private final IContractDetailService contractDetailService;

    @Autowired
    public ContractDetailController(IContractDetailService contractDetailService) {
        this.contractDetailService = contractDetailService;
    }
    @ModelAttribute("contracts")
    public Iterable<Contract> getListContract(){
        return contractDetailService.findAllContract();
    }
    @ModelAttribute("attachServices")
    public Iterable<AttachService> getListAttachService(){
        return contractDetailService.findAllAttachService();
    }
    @GetMapping("")
    public ModelAndView showListContract(){
        return new ModelAndView("contractDetail/contract-detail-list","contractDetails",contractDetailService.findAllNormal());
    }
    @GetMapping("/create")
    public ModelAndView createContractDetail(){
        return new ModelAndView("contractDetail/contract-detail-create","contractDetailDto",new ContractDetailDto());
    }
    @PostMapping("/create")
    public String saveContractDetailDto(@ModelAttribute(name = "contractDetailDto") @Valid ContractDetailDto contractDetailDto, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "contractDetail/contract-detail-create";
        }
        else {
            ContractDetail contract = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto,contract);
            this.contractDetailService.save(contract);
            return "redirect:/contract-detail/";
        }
    }
}
