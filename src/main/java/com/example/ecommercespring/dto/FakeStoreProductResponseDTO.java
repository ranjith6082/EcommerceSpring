package com.example.ecommercespring.dto;

import lombok.Data;

@Data
public class FakeStoreProductResponseDTO{
	private ProductDTO product;
	private String message;
	private String status;
}