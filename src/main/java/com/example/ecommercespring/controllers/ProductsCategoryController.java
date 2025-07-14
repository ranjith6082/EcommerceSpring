package com.example.ecommercespring.controllers;


import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductsItemDTO;
import com.example.ecommercespring.services.IProductsCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products/category")
public class ProductsCategoryController {


    private final IProductsCategoryService productsCategoryService;

    public ProductsCategoryController(IProductsCategoryService productsCategoryService) {
        this.productsCategoryService = productsCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductsItemDTO>> getAllProductByCategory(@RequestParam String type) throws IOException {
        List<ProductsItemDTO> result =  this.productsCategoryService.getAllProductsByCategory(type);
        return ResponseEntity.ok(result);
    }
}
