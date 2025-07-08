package com.example.ecommercespring.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreCategoryResponseDTO {

    private String status;

    private String message;

    private List<String> categories;
}
