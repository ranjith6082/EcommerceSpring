package com.example.ecommercespring.dto;

import lombok.Data;

@Data
public class ProductDTO {
	private String image;
	private String color;
	private int price;
	private String description;
	private int discount;
	private String model;
	private int id;
	private String title;
	private String category;
	private String brand;
	private boolean popular;
}