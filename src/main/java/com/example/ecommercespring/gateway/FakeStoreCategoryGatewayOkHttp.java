package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.*;
import com.example.ecommercespring.mappers.GetAllCategoriesMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

//@Primary
@Component("fakeStoreCategoryGatewayOkHttp")
public class FakeStoreCategoryGatewayOkHttp implements ICategoryGateway,IProductGateway,IProductsCategoryGateway {

    private final OkHttpClient client;
    private final String baseUrl;
    private final ObjectMapper objectMapper;

    public FakeStoreCategoryGatewayOkHttp(@Value("${base.url}") String baseUrl) {
        this.client = new OkHttpClient();
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        String url = baseUrl + "products/category";

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful() || response.body() == null) {
                throw new IOException("Failed to fetch categories");
            }

            FakeStoreCategoryResponseDTO responseDto = objectMapper.readValue(
                    response.body().string(),
                    FakeStoreCategoryResponseDTO.class
            );

            return GetAllCategoriesMapper.toCategoryDto(responseDto);
        }
    }

    @Override
    public List<ProductsItemDTO> getAllProductsByCategory(String type) throws IOException {
        String url = baseUrl + "products/category?type=" + URLEncoder.encode(type, StandardCharsets.UTF_8);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful() || response.body() == null) {
                throw new IOException("Failed to fetch product categories");
            }

            FakeStoreProductsCategoryResponseDTO responseDto = objectMapper.readValue(
                    response.body().string(),
                    FakeStoreProductsCategoryResponseDTO.class
            );

            return responseDto.getProducts();
        }
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {

        String url = baseUrl + "products/" + id;

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful() || response.body() == null) {
                throw new IOException("Failed to fetch single product");
            }

            FakeStoreProductResponseDTO responseDto = objectMapper.readValue(
                    response.body().string(),
                    FakeStoreProductResponseDTO.class
            );

            return responseDto.getProduct();
        }
    }
}
