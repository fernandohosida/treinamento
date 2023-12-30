package com.k2.example.ecommerceexample.product.service.validate;

import com.k2.example.ecommerceexample.product.model.CategoryPrincipalEnum;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class CategoryValidateDelegate {

    private final Map<CategoryPrincipalEnum, AbstractCategoryValidate<?>> typeIdentifier = new HashMap<>();

    public CategoryValidateDelegate(List<AbstractCategoryValidate<?>> type) {
        type.forEach(p -> typeIdentifier.put(p.getCatEnum(), p));
    }

    public AbstractCategoryValidate getProcessor(CategoryPrincipalEnum catEnum) {
        return typeIdentifier.get(catEnum);
    }

}
