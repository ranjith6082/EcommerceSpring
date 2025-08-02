package com.example.ecommercespring.dto.product;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductDTO {
	private Long id;
	private String image;
	private String color;
	private int price;
	private String description;
	private int discount;
	private String model;
	private String title;
	//private String category;
	private Long categoryId;
	private String brand;
	private boolean popular;
}