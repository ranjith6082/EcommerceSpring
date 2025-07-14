package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.CategoryDTO;
import com.example.ecommercespring.gateway.ICategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService{

    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(@Qualifier("fakeStoreCategoryGateway") ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }

//    @Override
//    public List<ProductDTO> getAllProductByCategory(String type) throws IOException {
//        return this.categoryGateway.getAllProductByCategory(type);
//    }

}
