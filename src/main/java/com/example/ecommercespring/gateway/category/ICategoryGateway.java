package com.example.ecommercespring.gateway.category;

import com.example.ecommercespring.dto.category.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    List<CategoryDTO> getAllCategories() throws IOException;

}
