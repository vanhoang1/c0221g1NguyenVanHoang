package com.product.controller;

import com.product.model.entity.Product;
import com.product.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {
    private final  IProductService productService;
    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }



    @GetMapping( path="")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable , @RequestParam(value = "keyword",required = false) String keyword ){
      String  keywordValue = "";
      if(keyword!=null)
      {
          keywordValue= keyword;
      }
        return new ModelAndView("index","productList",productService.findAll(pageable,keywordValue)).addObject("keyword",keyword);
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        return  new ModelAndView("create","product",new Product());
    }

    @PostMapping( path = {"save"})
    public  String saveProduct(Product product , RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("success",product.getId()==0?"Create successfully":"Update successfully");
        return "redirect:/";
    }
    @GetMapping(path ="/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable int id){
        return new ModelAndView("edit","product",productService.findById(id).orElse(new Product()));
    }
    @GetMapping(path ="/{id}/delete")
    public  String delete(@PathVariable int id , RedirectAttributes redirectAttributes) {
        productService.remove(id);
        redirectAttributes.addFlashAttribute("success","delete product successfully");
        return "redirect:/";
    }
    @GetMapping(path = "/{id}/view")
    public ModelAndView view(@PathVariable int id){
        return  new ModelAndView("/view","product",productService.findById(id));
    }

}
