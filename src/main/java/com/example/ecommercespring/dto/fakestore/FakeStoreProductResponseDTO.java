package com.example.ecommercespring.dto.fakestore;

import com.example.ecommercespring.dto.product.ProductDTO;
import lombok.Data;

@Data
public class FakeStoreProductResponseDTO{
	private ProductDTO product;
	private String message;
	private String status;
}