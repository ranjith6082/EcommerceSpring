package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductsItemDTO;

import java.io.IOException;
import java.util.List;

public interface IProductsCategoryService {

    List<ProductsItemDTO> getAllProductsByCategory(String type) throws IOException;
}
