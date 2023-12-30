package com.k2.example.ecommerceexample.product.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import com.k2.example.ecommerceexample.product.dto.CategoryDto;
import com.k2.example.ecommerceexample.product.model.Category;
import com.k2.example.ecommerceexample.product.model.CategoryPrincipalEnum;
import com.k2.example.ecommerceexample.product.repository.CategoryRepository;
import com.k2.example.ecommerceexample.product.service.validate.AbstractCategoryValidate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository repository;

    @Test
    void testSave() {

        CategoryDto categoryRequestDto = new CategoryDto(null, "CARRO", "AUTOMOVEL", CategoryPrincipalEnum.ELECTRONIC.name(), LocalDateTime.now());

        CategoryDto categoryResponseDto = categoryService.save(categoryRequestDto);

        Optional<Category> category = repository.findByName("CARRO");

        assertThat(category.isPresent());

        assertThat(category.get().getPrincipal().equals(CategoryPrincipalEnum.ELECTRONIC));

        assertThat(category.get().getId().isEmpty()).isFalse();

        assertThat(category.get().getId()).isNotNull();

        assertThat(categoryResponseDto.name().equals("CARRO"));

        assertThat(AbstractCategoryValidate.class).isAbstract();
    }

    @Test
    void testFindAllCategory() {

        List<Category> category = categoryService.findAll();

        assertThat(category.size()).isNotNull();

        assertThat(category.contains("FERRAMENTA"));

    }

    @Test
    void testMap() {
        Map<Integer, String> mapTest = new HashMap<>();

        mapTest.put(1, "teste1");
        mapTest.put(2, "teste2");
        mapTest.put(3, "teste3");

        assertThat(mapTest)
            .isNotEmpty()
            .containsKey(2)
            .doesNotContainKey(4)
            .contains(entry(3, "teste3"));

    }
}