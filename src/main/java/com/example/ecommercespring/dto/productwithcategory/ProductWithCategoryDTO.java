package com.example.ecommercespring.dto.productwithcategory;

import com.example.ecommercespring.dto.category.CategoryDTO;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductWithCategoryDTO {

    private Long id;
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private String title;
    private String brand;
    private boolean popular;

    private CategoryDTO category;
}
