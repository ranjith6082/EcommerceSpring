package com.example.ecommercespring.services.category;

import com.example.ecommercespring.dto.category.CategoryDTO;
import com.example.ecommercespring.dto.categorywithallproducts.AllProductsOfCategoryDTO;
import com.example.ecommercespring.dto.product.ProductDTO;
import com.example.ecommercespring.entity.Category;
import com.example.ecommercespring.exception.CategoryNotFoundException;
import com.example.ecommercespring.mappers.CategoryMapper;
import com.example.ecommercespring.mappers.ProductMapper;
import com.example.ecommercespring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }



    @Override
    public List<CategoryDTO> getAllCategories(){
        List<CategoryDTO> dtos = new ArrayList<>();
        for(Category category : repo.findAll()){
            dtos.add(CategoryMapper.toDto(category));
        }
        return dtos;
    }


    @Override
    public CategoryDTO getByName(String name) throws IOException {
        Category category = repo.findByName(name)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with name: "+name));
        return CategoryMapper.toDto(category);
    }



    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException {
        Category category = CategoryMapper.toEntity(categoryDTO);
        Category saved = repo.save(category);
        return CategoryMapper.toDto(saved);
    }


    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws IOException {
        Category category = repo.findById(categoryId)
                .orElseThrow(() -> new IOException("Category not found with id: " + categoryId));

//        List<ProductDTO> productDTOs = category.getProducts()
//                .stream()
//                .map(product -> ProductMapper.toDtO(product))
//                .collect(Collectors.toList());
//
//        return AllProductsOfCategoryDTO.builder()
//                .categoryId(category.getId())
//                .name(category.getName())
//                .products(productDTOs)
//                .build();
        return CategoryMapper.toCategoryWithAllProductsDTO(category);
    }
}
