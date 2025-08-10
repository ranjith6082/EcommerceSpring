package com.example.ecommercespring.services;


import com.example.ecommercespring.dto.category.CategoryDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.repository.CategoryRepository;
import com.example.ecommercespring.services.category.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)     // Use MockitoExtension to enable Mockito annotations with JUnit
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository; // Mock the CategoryRepository to simulate database interactions without needing a real database

    @InjectMocks
    private CategoryService categoryService;  // Inject the mocked CategoryRepository into the CategoryService instance

    @Test
    @DisplayName("should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() {
        //Arrange
        List<Category> categories = new ArrayList<>();
        Category category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        Category category2 = Category.builder().name("Books").build();
        category2.setId(2L);
        Category category3 = Category.builder().name("Clothing").build();
        category3.setId(3L);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        when(categoryRepository.findAll()).thenReturn(categories);  // Mock the repository to return the predefined list of categories

        //Act

        List<CategoryDTO> result = categoryService.getAllCategories();  // Call the method under test

        //Assert
        assertEquals(result.size(),3);  // Verify that the size of the returned list is as expected
        verify(categoryRepository,times(1)).findAll();  // Verify that the findAll method of the repository is called exactly once

    }

}
