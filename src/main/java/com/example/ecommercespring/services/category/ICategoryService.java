package com.example.ecommercespring.services.category;

import com.example.ecommercespring.dto.category.CategoryDTO;
import com.example.ecommercespring.dto.categorywithallproducts.AllProductsOfCategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getAllCategories() throws IOException;

    CategoryDTO getByName(String name) throws IOException;

    CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException;

    AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws IOException;
}
