package com.controller;

import com.model.bean.Product;
import com.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    private final  IProductService productService;
    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping( path="")
    public ModelAndView showList(){
        return new ModelAndView("/index","productList",productService.findAll());
    }
    @GetMapping("/create")
    public  ModelAndView showFormCreate(){
        return  new ModelAndView("/create","product",new Product());
    }

    @PostMapping( path = "/create")
    public  String saveProduct(Product product , RedirectAttributes redirectAttributes){
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","create product successfully");
        return "redirect:/";
    }
    @GetMapping(path ="/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable int id){
        return new ModelAndView("/edit","product",productService.findById(id));
    }
    @PostMapping(path ="/update")
    public String update(Product product, RedirectAttributes redirectAttributes){
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("success","update product successfully");
        return "redirect:/";
    }
    @GetMapping(path ="/{id}/delete")
    public  String delete(@PathVariable int id , RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("success","delete product successfully");
        return "redirect:/";
    }
    @GetMapping(path="/search")
    public ModelAndView search(@RequestParam(value = "search", required = false) String search){
        return new ModelAndView("/index","productList",productService.findByName(search));
    }
    @GetMapping(path = "/{id}/view")
    public ModelAndView view(@PathVariable int id){
        return  new ModelAndView("/view","product",productService.findById(id));
    }
}
