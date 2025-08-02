package com.example.ecommercespring.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String name;


    //one category has many products
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Product> products;


}
