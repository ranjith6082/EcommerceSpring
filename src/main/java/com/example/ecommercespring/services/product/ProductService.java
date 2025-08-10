package com.example.ecommercespring.services.product;

import com.example.ecommercespring.dto.product.ProductDTO;
import com.example.ecommercespring.dto.productwithcategory.ProductWithCategoryDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.entity.Product;
import com.example.ecommercespring.exception.ProductNotFoundException;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.repository.CategoryRepository;
import com.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repo, CategoryRepository categoryRepository) {
        this.repo = repo;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
//        return repo.findById(id)
//                .map(ProductMapper::toDTO)
//                .orElseThrow(() -> new IOException("Product not found with id: " + id));
        Product product = repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return ProductMapper.toDtO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws IOException {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new IOException("Category not found"));

        Product saved = repo.save(ProductMapper.toEntity(dto,category));
        return ProductMapper.toDtO(saved);
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws IOException {
        Product product = repo.findById(id)
                .orElseThrow(() -> new IOException("Product not found"));
        return ProductMapper.toProductWithCategoryDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        List<Product> products = repo.findAll();
        if(products.isEmpty()){
            throw new IOException("No products found");
        }
        return products.stream().map(ProductMapper::toDtO)
                .toList();
    }

    @Override
    public void deleteProductById(Long id) throws IOException {
        Product product = repo.findById(id)
                .orElseThrow(() -> new IOException("Product not found with id: " + id));
        repo.delete(product);
    }

    @Override
    public ProductDTO updateProductBrand(Long id, String brand) throws IOException {
        Product product = repo.findById(id)
                .orElseThrow(() -> new IOException("Product not found with id: " + id));

        product.setBrand(brand);
        Product updated = repo.save(product);

        return ProductMapper.toDtO(product);
    }

}
