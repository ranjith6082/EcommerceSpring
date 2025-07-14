package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.ProductsItemDTO;

import java.io.IOException;
import java.util.List;

public interface IProductsCategoryGateway {

    List<ProductsItemDTO> getAllProductsByCategory(String type) throws IOException;
}
