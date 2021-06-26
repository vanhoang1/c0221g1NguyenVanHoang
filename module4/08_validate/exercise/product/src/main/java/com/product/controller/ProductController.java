package com.product.controller;

import com.product.model.entity.Product;
import com.product.model.entity.dto.ProductDto;
import com.product.model.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
        return new ModelAndView("create-or-edit","productDto",new ProductDto());
    }

    @PostMapping( path = {"save"})
    public  String saveProduct(@Valid @ModelAttribute("productDto") ProductDto productDto, BindingResult bindingResult , RedirectAttributes redirectAttributes){

        if(bindingResult.hasFieldErrors()){
            return "create-or-edit";
        }
        else{
         Product product = new Product();
         BeanUtils.copyProperties(productDto,product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("success",product.getId()==0?"Create successfully":"Update successfully");
        return "redirect:/";
        }
    }
    @GetMapping(path ="/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable int id){
        Product product = productService.findById(id).orElse(new Product());
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        return new ModelAndView("create-or-edit","productDto",productDto);
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
