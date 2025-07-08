package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getAllCategories() throws IOException;
}
