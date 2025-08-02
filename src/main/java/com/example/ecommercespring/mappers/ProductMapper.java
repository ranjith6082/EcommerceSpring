package com.example.ecommercespring.mappers;

import com.example.ecommercespring.dto.product.ProductDTO;
import com.example.ecommercespring.dto.productwithcategory.ProductWithCategoryDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDTO toDtO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .categoryId(product.getCategory().getId())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDTO productDTO, Category category) {
        return Product.builder()
                .image(productDTO.getImage())
                .color(productDTO.getColor())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .discount(productDTO.getDiscount())
                .model(productDTO.getModel())
                .title(productDTO.getTitle())
                .category(category)
                .brand(productDTO.getBrand())
                .popular(productDTO.isPopular())
                .build();
    }

    public static ProductWithCategoryDTO toProductWithCategoryDTO(Product product) {
        return ProductWithCategoryDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .category(CategoryMapper.toDto(product.getCategory()))
                .build();
    }

    public static List<ProductDTO> toDtoList(List<Product> products) {
        return products.stream()
                .map(ProductMapper::toDtO)
                .collect(Collectors.toList());
    }
}
