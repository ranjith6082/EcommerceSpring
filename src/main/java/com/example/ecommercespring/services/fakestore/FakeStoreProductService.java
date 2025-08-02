package com.example.ecommercespring.services.fakestore;

import com.example.ecommercespring.dto.product.ProductDTO;
import com.example.ecommercespring.dto.productwithcategory.ProductWithCategoryDTO;
import com.example.ecommercespring.gateway.product.IProductGateway;
import com.example.ecommercespring.services.product.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FakeStoreProductService implements IProductService {

    private final IProductGateway productGateway;

    public FakeStoreProductService(@Qualifier("fakeStoreProductGateway") IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        return this.productGateway.getProductById(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws IOException {
        return null;
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws IOException {
        return null;
    }
}
