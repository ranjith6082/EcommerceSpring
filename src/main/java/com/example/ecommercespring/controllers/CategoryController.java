package com.example.ecommercespring.controllers;

import com.example.ecommercespring.dto.category.CategoryDTO;
import com.example.ecommercespring.dto.categorywithallproducts.AllProductsOfCategoryDTO;
import com.example.ecommercespring.exception.CategoryNotFoundException;
import com.example.ecommercespring.exception.ProductNotFoundException;
import com.example.ecommercespring.services.category.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    //@Autowired
    private final ICategoryService categoryService;

    CategoryController(ICategoryService categoryService){
        this.categoryService = categoryService;
    }

//    @GetMapping
//    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {
//        List<CategoryDTO> result =  this.categoryService.getAllCategories();
//        return ResponseEntity.ok(result);
//    }

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required=false) String name) throws IOException{
        if(name != null && !name.isBlank()){
            CategoryDTO categoryDTO = categoryService.getByName(name);
            return ResponseEntity.ok(categoryDTO);
        }else{
            List<CategoryDTO> result = this.categoryService.getAllCategories();
            return ResponseEntity.ok(result);
        }
    }


    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws IOException {
        CategoryDTO created = categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok(created);
    }


    @GetMapping("/{id}/products")
    public ResponseEntity<AllProductsOfCategoryDTO> getAllProductsOfCategory(@PathVariable long id) throws Exception{

        AllProductsOfCategoryDTO dto = categoryService.getAllProductsOfCategory(id);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCategoryByName(@RequestParam String name) throws IOException {
        categoryService.deleteCategoryByName(name);
        return ResponseEntity.noContent().build(); // HTTP 204
    }


    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategoryNameById(
            @PathVariable Long id,
            @RequestParam String name) throws IOException {

        CategoryDTO updated = categoryService.updateCategoryNameById(id, name);
        return ResponseEntity.ok(updated);
    }


}
