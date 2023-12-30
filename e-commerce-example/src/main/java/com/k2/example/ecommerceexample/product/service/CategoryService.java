package com.k2.example.ecommerceexample.product.service;

import com.k2.example.ecommerceexample.product.dto.CategoryDto;
import com.k2.example.ecommerceexample.product.exceptions.CategoryNotFoundException;
import com.k2.example.ecommerceexample.product.model.Category;
import com.k2.example.ecommerceexample.product.model.CategoryPrincipalEnum;
import com.k2.example.ecommerceexample.product.repository.CategoryRepository;
import com.k2.example.ecommerceexample.product.service.validate.AbstractCategoryValidate;
import com.k2.example.ecommerceexample.product.service.validate.CategoryValidateDelegate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryValidateDelegate categoryValidateDelegate;

    public Category findCategory(String category) {
        Optional<Category> cat = categoryRepository.findByName(category);
        if (cat.isPresent()) {
            return cat.get();
        } else {
            throw new CategoryNotFoundException("category not found");
        }

    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryDto save(CategoryDto categoryDto) {
        CategoryPrincipalEnum enumValue = getEnumValue(categoryDto);

        AbstractCategoryValidate validate = categoryValidateDelegate.getProcessor(enumValue);

        validate.validate(categoryDto);

        Category cat = Category.builder().name(categoryDto.name()).created_at(LocalDateTime.now()).principal(enumValue).build();
        cat = categoryRepository.save(cat);
        return new CategoryDto(cat.getId(), cat.getName(), null, enumValue.name(), cat.getCreated_at());

    }

    private CategoryPrincipalEnum getEnumValue(CategoryDto categoryDto) {
        return CategoryPrincipalEnum.valueOf(categoryDto.principal());
    }
}
