package com.example.ecommercespring.gateway.product;

import com.example.ecommercespring.dto.product.ProductDTO;

import java.io.IOException;

public interface IProductGateway {

    ProductDTO getProductById(Long id) throws IOException;

}
