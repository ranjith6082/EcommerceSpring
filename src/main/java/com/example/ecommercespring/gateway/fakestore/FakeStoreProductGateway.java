package com.example.ecommercespring.gateway.fakestore;

import com.example.ecommercespring.dto.fakestore.FakeStoreProductResponseDTO;
import com.example.ecommercespring.dto.product.ProductDTO;
import com.example.ecommercespring.gateway.api.FakeStoreProductApi;
import com.example.ecommercespring.gateway.product.IProductGateway;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("fakeStoreProductGateway")
public class FakeStoreProductGateway implements IProductGateway {

    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        FakeStoreProductResponseDTO response = this.fakeStoreProductApi.getFakeProduct(id).execute().body();
        if (response == null) {
            throw new IOException("Failed to fetch product with id: " + id);
        }
        return response.getProduct();
    }
}
