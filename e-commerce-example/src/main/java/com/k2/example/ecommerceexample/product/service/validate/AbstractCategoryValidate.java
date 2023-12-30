package com.k2.example.ecommerceexample.product.service.validate;

import com.k2.example.ecommerceexample.product.dto.CategoryDto;
import com.k2.example.ecommerceexample.product.model.CategoryPrincipalEnum;

public abstract class AbstractCategoryValidate<T> {

    public abstract void validate(CategoryDto category);

    public abstract CategoryPrincipalEnum getCatEnum();
}
