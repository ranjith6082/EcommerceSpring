package com.example.ecommercespring.services.fakestore;

import com.example.ecommercespring.dto.category.CategoryDTO;
import com.example.ecommercespring.dto.categorywithallproducts.AllProductsOfCategoryDTO;
import com.example.ecommercespring.gateway.category.ICategoryGateway;
import com.example.ecommercespring.services.category.ICategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {

    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(@Qualifier("fakeStoreCategoryGateway") ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException{
        return this.categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO getByName(String name) throws IOException {
        return null;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException {
        return null;
    }

    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long id) throws IOException {
        return null;
    }

    @Override
    public void deleteCategoryByName(String name) throws IOException {

    }

    @Override
    public CategoryDTO updateCategoryNameById(Long id, String name) throws IOException {
        return null;
    }

}
