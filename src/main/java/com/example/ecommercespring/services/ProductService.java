package com.example.ecommercespring.services;

import com.example.ecommercespring.dto.ProductDTO;
import com.example.ecommercespring.entity.Product;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProductService implements IProductService{

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
//        return repo.findById(id)
//                .map(ProductMapper::toDTO)
//                .orElseThrow(() -> new IOException("Product not found with id: " + id));
        Product product = repo.findById(id)
                .orElseThrow(() -> new IOException("Product not found with id: " + id));
        return ProductMapper.toDTO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws IOException {
        Product saved = repo.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDTO(saved);
    }
}
