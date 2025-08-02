package com.example.ecommercespring.services.product;

import com.example.ecommercespring.dto.product.ProductDTO;
import com.example.ecommercespring.dto.productwithcategory.ProductWithCategoryDTO;

import java.io.IOException;

public interface IProductService {

    ProductDTO getProductById(Long id) throws IOException;
    ProductDTO createProduct(ProductDTO dto) throws IOException;

    ProductWithCategoryDTO getProductWithCategory(Long id) throws IOException;
}
