package com.example.ecommercespring.dto.categorywithallproducts;

import com.example.ecommercespring.dto.product.ProductDTO;
import lombok.*;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllProductsOfCategoryDTO {

    private Long categoryId;
    private String name;

    private List<ProductDTO> products;
}
