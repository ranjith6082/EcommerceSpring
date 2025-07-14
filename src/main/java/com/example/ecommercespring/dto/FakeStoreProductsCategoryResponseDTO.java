package com.example.ecommercespring.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductsCategoryResponseDTO{
	private String message;
	private String status;
	private List<ProductsItemDTO> products;
}