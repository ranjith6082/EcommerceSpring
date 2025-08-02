package com.example.ecommercespring.dto.fakestore;

import java.util.List;

import com.example.ecommercespring.dto.ProductsItemDTO;
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