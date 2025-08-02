package com.example.ecommercespring.gateway.api;

import com.example.ecommercespring.dto.fakestore.FakeStoreProductsCategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.io.IOException;

public interface FakeStoreProductsCategoryApi {

    @GET("products/category")
    Call<FakeStoreProductsCategoryResponseDTO> getAllProductsByCategory(
            @Query("type") String type
    )throws IOException;
}
