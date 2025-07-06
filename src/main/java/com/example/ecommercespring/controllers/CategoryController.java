package com.example.ecommercespring.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @GetMapping
    public String getCategory(){
        return "Electronics";
    }

    @PostMapping
    public String getPostCategory(){
        return "Post Electronics";
    }

    //if we call a GET request on /api/categories/count
    @GetMapping("/count")
    public int getCategoryCount(){
        return 5;
    }

    @DeleteMapping
    public String deleteCategory(){
        return "Category deleted";
    }
}
