package com.k2.example.ecommerceexample.product.service.validate;

import com.k2.example.ecommerceexample.product.dto.CategoryDto;
import com.k2.example.ecommerceexample.product.model.CategoryPrincipalEnum;
import org.springframework.stereotype.Component;

@Component
public class CategoryFoodValidateProcessor extends AbstractCategoryValidate<CategoryFoodValidate> {

    @Override
    public void validate(CategoryDto categoryDto) {
        System.out.println("CategoryFoodValidate");
    }

    @Override
    public CategoryPrincipalEnum getCatEnum() {
        return CategoryPrincipalEnum.FOOD;
    }
}
