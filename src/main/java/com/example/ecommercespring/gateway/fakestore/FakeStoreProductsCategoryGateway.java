package com.example.ecommercespring.gateway.fakestore;

import com.example.ecommercespring.dto.fakestore.FakeStoreProductsCategoryResponseDTO;
import com.example.ecommercespring.dto.ProductsItemDTO;
import com.example.ecommercespring.gateway.IProductsCategoryGateway;
import com.example.ecommercespring.gateway.api.FakeStoreProductsCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreProductsCategoryGateway")
public class FakeStoreProductsCategoryGateway implements IProductsCategoryGateway {

    private final FakeStoreProductsCategoryApi fakeStoreProductsCategoryApi;

    public FakeStoreProductsCategoryGateway(FakeStoreProductsCategoryApi fakeStoreProductsCategoryApi) {
        this.fakeStoreProductsCategoryApi = fakeStoreProductsCategoryApi;
    }

    @Override
    public List<ProductsItemDTO> getAllProductsByCategory(String type) throws IOException {
        FakeStoreProductsCategoryResponseDTO response = this.fakeStoreProductsCategoryApi
                .getAllProductsByCategory(type) // Pass type as query param
                .execute()
                .body();

        if (response == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }

        return response.getProducts();
    }
}
