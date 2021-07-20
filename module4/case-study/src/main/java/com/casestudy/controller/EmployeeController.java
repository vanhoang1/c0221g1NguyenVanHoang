package com.casestudy.controller;

import com.casestudy.model.entity.account.AppUser;
import com.casestudy.model.entity.customer.Customer;
import com.casestudy.model.entity.dto.CustomerDto;
import com.casestudy.model.entity.dto.EmployeeDto;
import com.casestudy.model.entity.employee.Division;
import com.casestudy.model.entity.employee.Education;
import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.entity.employee.Position;
import com.casestudy.model.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private  final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("")
    public ModelAndView showListEmployee(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value="keyword",defaultValue = "",required = false) String keyword){
        if(keyword== null) keyword="";
        Page<Employee> employees = employeeService.findAll(pageable,keyword);
        return new ModelAndView("employee/employee-list","employees",employees).addObject("keyword",keyword);
    }
    @PreAuthorize("hasRole('giam doc')")
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("employee/employee-create","employeeDto",new EmployeeDto());
    }
    @PostMapping("/create")
    public String saveEmployee(@ModelAttribute(name = "employeeDto") @Valid EmployeeDto employeeDto, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "employee/employee-create";
        }
        else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            employee.setFlag(true);
            this.employeeService.save(employee);
            return "redirect:/employees/";
        }
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable Long id, Model model){
        Optional<Employee> employee = this.employeeService.findById(id);

        if(employee.isPresent()){
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employee.get(),employeeDto);
            model.addAttribute("employeeDto",employeeDto);
            return "/employee/employee-edit";
        }
        else {
            return "redirect:/employees/";
        }
    }
    @PostMapping("/edit/{id}")
    public String editEmployee(@ModelAttribute(name = "employeeDto") @Valid EmployeeDto employeeDto, BindingResult bindingResult,@PathVariable Long id){
        if(bindingResult.hasFieldErrors()){
            return "employee/employee-create";
        }
        else {
            Optional<Employee> employee = this.employeeService.findById(id);
            if(employee.isPresent()){
                BeanUtils.copyProperties(employeeDto,employee.get());
                this.employeeService.save(employee.get());
            }

            return "redirect:/employees/";
        }
    }
    @GetMapping("/del/{id}")
    public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAttributes){
        Optional<Employee> employee = this.employeeService.findById(id);

        if(employee.isPresent()){
            this.employeeService.remove(id);
            redirectAttributes.addFlashAttribute("message","delete successfully !");
        }
        return "redirect:/employees/";
    }
    @ModelAttribute("positions")
    public Iterable<Position> getListPosition(){
        return employeeService.findAllPosition();
    }
    @ModelAttribute("divisions")
    public Iterable<Division> getListDivision(){
        return employeeService.findAllDivision();
    }
    @ModelAttribute("educations")
    public Iterable<Education> getListEducation(){
        return employeeService.findAllEducation();
    }
    @ModelAttribute("users")
    public Iterable<AppUser> getListUser(){
        return employeeService.findAllUser();
    }

}
