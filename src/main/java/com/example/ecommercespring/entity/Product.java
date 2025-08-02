package com.example.ecommercespring.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity{

    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    //private int id;
    private String title;
    //private String category;
    private String brand;
    private boolean popular;

    //Each product belongs to one category
    //and one category can have multiple products
    //@ManyToOne(fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable = false)
    private Category category;
}
