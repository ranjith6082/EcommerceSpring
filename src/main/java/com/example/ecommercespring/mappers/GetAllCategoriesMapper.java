package com.example.ecommercespring.mappers;

import com.example.ecommercespring.dto.category.CategoryDTO;
import com.example.ecommercespring.dto.fakestore.FakeStoreCategoryResponseDTO;

import java.util.List;

public class GetAllCategoriesMapper {

    public static List<CategoryDTO> toCategoryDto(FakeStoreCategoryResponseDTO dto) {
        return dto.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
