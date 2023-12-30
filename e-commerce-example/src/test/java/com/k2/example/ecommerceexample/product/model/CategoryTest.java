package com.k2.example.ecommerceexample.product.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void testCategory() {
        Category category = Category.builder().name("TESTE").principal(CategoryPrincipalEnum.FOOD).description("DESCRIPTION").build();

        assertThat(category.getName().equals("TESTE"));
        assertThat(category.getPrincipal().equals(CategoryPrincipalEnum.FOOD));

    }
}