package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.dto.ProductsItemDTO;
import com.example.ecommercespring.gateway.IProductsCategoryGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreProductsCategoryService implements IProductsCategoryService{

    private final IProductsCategoryGateway productsCategoryGateway;

    public FakeStoreProductsCategoryService(@Qualifier("fakeStoreProductsCategoryGateway") IProductsCategoryGateway productsCategoryGateway) {
        this.productsCategoryGateway = productsCategoryGateway;
    }

    @Override
    public List<ProductsItemDTO> getAllProductsByCategory(String type) throws IOException {
        return this.productsCategoryGateway.getAllProductsByCategory(type);
    }
}
