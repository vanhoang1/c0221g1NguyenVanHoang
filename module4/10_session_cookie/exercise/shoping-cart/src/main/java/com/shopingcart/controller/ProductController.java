package com.shopingcart.controller;

import com.shopingcart.model.entity.Cart;
import com.shopingcart.model.entity.Product;
import com.shopingcart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(@ModelAttribute(value = "cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/del/{id}")
    public String delFromCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) throws Exception {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.delProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.delProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) throws Exception {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.removeProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.removeProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/detail/{id}")
    public String detailShow(@PathVariable Long id, Model model){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        model.addAttribute("product",productOptional.get());
        return "detail";
    }
    @GetMapping("/clearCart")
    public String clearCart( @ModelAttribute Cart cart){
        cart.clearMap();
        return "redirect:/shop";
    }
    @ExceptionHandler(Exception.class)
    public String handleExceptionProduct(RedirectAttributes redirectAttributes,Exception e){
        redirectAttributes.addFlashAttribute("error",e.getMessage());
        return "redirect:/shop";
    }
}