package com.k2.example.ecommerceexample.product.dto;

import java.time.LocalDateTime;

public record CategoryDto(String id, String name, String description, String principal, LocalDateTime createdAt) {

}
