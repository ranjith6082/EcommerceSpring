package com.example.ecommercespring.mappers;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.entity.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .category(product.getCategory())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDTO productDTO) {
        return Product.builder()
                .title(productDTO.getTitle())
                .image(productDTO.getImage())
                .color(productDTO.getColor())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .discount(productDTO.getDiscount())
                .model(productDTO.getModel())
                .category(productDTO.getCategory())
                .brand(productDTO.getBrand())
                .popular(productDTO.isPopular())
                .build();
    }
}
