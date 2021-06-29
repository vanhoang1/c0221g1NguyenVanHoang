package com.shopingcart.controller;


import com.shopingcart.model.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ShoppingCartController {

    @ModelAttribute("cart")
    public Model setupCart(Model model) {
        return model.addAttribute( new Cart());
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute(name = "cart",required = false) Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
}