package com.k2.example.ecommerceexample.product.model;


import com.k2.example.ecommerceexample.product.service.validate.CategoryElectronicValidate;
import com.k2.example.ecommerceexample.product.service.validate.CategoryFoodValidate;
import com.k2.example.ecommerceexample.product.service.validate.CategoryFurnitureValidate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CategoryPrincipalEnum {
    FOOD(CategoryFoodValidate.class),
    ELECTRONIC(CategoryElectronicValidate.class),
    FURNITURE(CategoryFurnitureValidate.class);

    private final Class<?> validateType;

}
