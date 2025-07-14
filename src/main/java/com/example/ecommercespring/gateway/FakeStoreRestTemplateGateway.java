package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.*;
import com.example.ecommercespring.mappers.GetAllCategoriesMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
//@Primary
public class FakeStoreRestTemplateGateway implements ICategoryGateway,IProductGateway,IProductsCategoryGateway{

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.in/api/products/category";

        ResponseEntity<FakeStoreCategoryResponseDTO> response = restTemplate.getForEntity(url, FakeStoreCategoryResponseDTO.class);
        if (response.getBody() == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }
        return GetAllCategoriesMapper.toCategoryDto(response.getBody());
    }

    @Override
    public List<ProductsItemDTO> getAllProductsByCategory(String type) throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.in/api/products/category?type="+ URLEncoder.encode(type, StandardCharsets.UTF_8);
        ResponseEntity<FakeStoreProductsCategoryResponseDTO> response = restTemplate.getForEntity(url, FakeStoreProductsCategoryResponseDTO.class);
        if (response.getBody() == null) {
            throw new IOException("Failed to fetch products by category from FakeStore API");
        }

        return response.getBody().getProducts();
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.in/api/products/"+id;
        ResponseEntity<FakeStoreProductResponseDTO> response = restTemplate.getForEntity(url, FakeStoreProductResponseDTO.class);
        if (response.getBody() == null) {
            throw new IOException("Failed to fetch products by category from FakeStore API");
        }
        return response.getBody().getProduct();
    }
}
