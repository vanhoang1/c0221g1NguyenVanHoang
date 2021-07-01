package com.blogspring.controller;

import com.blogspring.model.entity.Blog;
import com.blogspring.model.entity.Category;
import com.blogspring.model.service.blog.IBlogService;
import com.blogspring.model.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BlogApiController {
    private final IBlogService blogService;
    private  final ICategoryService categoryService;

    @Autowired
    public BlogApiController(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }
    @GetMapping(path = "/categorys")
    public ResponseEntity<Iterable<Category>> findAllCategory(){
        List<Category> categorys = (List<Category>) categoryService.findAll();
        if(categorys.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categorys,HttpStatus.OK);
    }
    @GetMapping(path = "/blogs")
    public ResponseEntity<Iterable<Blog>> findAllBlog(){
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping(path = "/categorys/{id}/blogs")
    public ResponseEntity<Iterable<Blog>> findAllBlogByCategoryId(@PathVariable Long id){
        List<Blog> blogs = (List<Blog>) blogService.findAllByCategoryId(id);
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping(path = "/blogs/{id}")
    public ResponseEntity<Optional<Blog>> findBlogById(@PathVariable Long id){
        Optional<Blog> blog =  blogService.findById(id);
        if(!blog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> searchByTitle(@RequestParam(name="title",required = false) String title , @PageableDefault(size=3) Pageable pageable ){

        if(title==null) title="";
        Page<Blog> blogs=  blogService.findAllByTitle(title,pageable);
        if(blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
}
