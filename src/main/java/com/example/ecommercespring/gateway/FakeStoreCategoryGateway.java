package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.*;
import com.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import com.example.ecommercespring.mappers.GetAllCategoriesMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreCategoryGateway")
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        // 1. Make the HTTP request to the FakeStore API to fetch all categories
        FakeStoreCategoryResponseDTO response =  this.fakeStoreCategoryApi.getAllFakeCategories().execute().body();

        // 2. Check if the response is null and throw an IOException if it is
        if(response == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }
        // 3. Map the response to a list of CategoryDTO objects
        return GetAllCategoriesMapper.toCategoryDto(response);
    }
}
