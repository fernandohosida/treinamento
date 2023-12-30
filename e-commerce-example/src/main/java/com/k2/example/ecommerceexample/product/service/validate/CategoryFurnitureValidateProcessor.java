package com.k2.example.ecommerceexample.product.service.validate;

import com.k2.example.ecommerceexample.product.dto.CategoryDto;
import com.k2.example.ecommerceexample.product.model.CategoryPrincipalEnum;
import org.springframework.stereotype.Component;

@Component
public class CategoryFurnitureValidateProcessor extends AbstractCategoryValidate<CategoryFurnitureValidate> {

    @Override
    public void validate(CategoryDto categoryDto) {
        System.out.println("CategoryFurnitureValidate");
    }

    @Override
    public CategoryPrincipalEnum getCatEnum() {
        return CategoryPrincipalEnum.FURNITURE;
    }
}
