package com.example.ecommercespring.controllers;


import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws IOException {
        ProductDTO result = this.productService.getProductById(id);
        return ResponseEntity.ok(result);
    }
}
