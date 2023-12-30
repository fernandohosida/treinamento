package com.k2.example.ecommerceexample.product.controller;

import com.k2.example.ecommerceexample.product.dto.CategoryDto;
import com.k2.example.ecommerceexample.product.model.Category;
import com.k2.example.ecommerceexample.product.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getCategories() {

        List<Category> categories = categoryService.findAll();

        List<CategoryDto> categoryDtos = categories.stream().map(a -> categoryToDto(a)).toList();
        return ResponseEntity.ok(categoryDtos);
    }

    private CategoryDto categoryToDto(Category a) {
        return new CategoryDto(a.getId().toString(), a.getName(), a.getDescription(),a.getPrincipal().name(),a.getCreated_at());
    }

    @PostMapping
    public ResponseEntity<CategoryDto> postCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.save(categoryDto));
    }

}
