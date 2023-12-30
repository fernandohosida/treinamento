package com.k2.example.ecommerceexample.product.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public record ProductDto(

    String id,
    String name,
    String category,
    BigDecimal value,
    LocalDateTime createdAt
) {

}