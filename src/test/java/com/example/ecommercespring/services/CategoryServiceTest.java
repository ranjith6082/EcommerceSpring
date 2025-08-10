package com.example.ecommercespring.services;


import com.example.ecommercespring.dto.category.CategoryDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.repository.CategoryRepository;
import com.example.ecommercespring.services.category.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)     // Use MockitoExtension to enable Mockito annotations with JUnit
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository; // Mock the CategoryRepository to simulate database interactions without needing a real database

    @InjectMocks
    private CategoryService categoryService;  // Inject the mocked CategoryRepository into the CategoryService instance


    private CategoryDTO categoryDTO;  // CategoryDTO object to be used in tests
    private Category category1;  // Category entity to be used in tests
    private Category category2;  // Another Category entity to be used in tests
    private Category category3; // Another Category entity to be used in tests

    @BeforeEach
    void setUp(){
        categoryDTO = CategoryDTO.builder().name("Electronics").build();  // Initialize the categoryDTO with a name
        category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        category2 = Category.builder().name("Books").build();
        category2.setId(2L);
        category3 = Category.builder().name("Clothing").build();
        category3.setId(3L);
    }


    @Test
    @DisplayName("should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() {
        //Arrange
        List<Category> categories = new ArrayList<>();

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

    @Test
    @DisplayName("Should return empty list when no categories are found")
    void getAllCategories_shouldReturnEmptyListWhenNoCategoriesFound() {
        //Arrange
        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());  // Mock the repository to return an empty list

        //Act
        List<CategoryDTO> result = categoryService.getAllCategories();  // Call the method under test

        //Assert
        assertEquals(result.size(),0);  // Verify that the size of the returned list is zero
        verify(categoryRepository,times(1)).findAll();  // Verify that the findAll method of the repository is called exactly once
    }


    @Test
    @DisplayName("create a new category successfully")
    void createCategory_shouldCreateNewCategory() throws IOException {
        //Arrange

        when(categoryRepository.save(any(Category.class))).thenReturn(category1);  // Mock the save method to return the created category

        //Act
        CategoryDTO result = categoryService.createCategory(categoryDTO);  // Call the method under test

        //Assert
        assertEquals(result.getName(), "Electronics");  // Verify that the name of the returned category matches the expected value
        verify(categoryRepository, times(1)).save(any(Category.class));  // Verify that the save method of the repository is called exactly once
    }



    @Test
    @DisplayName("Should return category by name successfully")
    void getCategoryByName_shouldReturnCategoryByName() throws IOException {
        //Arrange
        when(categoryRepository.findByName("Electronics")).thenReturn(Optional.of(category1));  // Mock the repository to return the category with the specified name

        //Act
        CategoryDTO result = categoryService.getByName("Electronics");  // Call the method under test

        //Assert
        assertEquals(result.getName(), "Electronics");  // Verify that the name of the returned category matches the expected value
        verify(categoryRepository, times(1)).findByName("Electronics");  // Verify that the findByName method of the repository is called exactly once
    }
}
