package com.casestudy.controller;

import com.casestudy.model.entity.account.AppUser;
import com.casestudy.model.entity.account.AppUserDetail;
import com.casestudy.model.entity.employee.Employee;
import com.casestudy.model.repository.user.IUserRepository;
import com.casestudy.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;


@Controller
public class HomeController {


    @GetMapping(path = "")
    public String goHomePage(){
        return "common/index";
    }
    @GetMapping("/login")
    public String loginPage(Model model) {
        return "common/loginPage";
    }
    @GetMapping("/logoutSuccessful")
    public String logout(Model model) {
        model.addAttribute("message","logout success fully");
        return "common/loginPage";
    }
    @GetMapping("/403")
    public String accessDenied(Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message","Access Denied");
        return "redirect:/";
    }
    @GetMapping("/loginSuccessful")
    public String login(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AppUserDetail appUserDetail = (AppUserDetail) auth.getPrincipal();
        model.addAttribute("appUserDetail",appUserDetail);
        return "common/index";
    }
    @ModelAttribute("currentUser")
    public UserDetails getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (UserDetails) authentication.getPrincipal();
    }
}
