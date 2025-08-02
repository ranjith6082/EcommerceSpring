package com.example.ecommercespring.mappers;

import com.example.ecommercespring.dto.category.CategoryDTO;
import com.example.ecommercespring.dto.categorywithallproducts.AllProductsOfCategoryDTO;
import com.example.ecommercespring.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toDto(Category entity){
        return CategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }


    public static AllProductsOfCategoryDTO toCategoryWithAllProductsDTO(Category category){
        return AllProductsOfCategoryDTO.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .products(ProductMapper.toDtoList(category.getProducts()))
                .build();
    }
}
