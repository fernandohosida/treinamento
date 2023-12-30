package com.k2.example.ecommerceexample.product.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.k2.example.ecommerceexample.product.model.Category;
import com.k2.example.ecommerceexample.product.model.CategoryPrincipalEnum;
import com.k2.example.ecommerceexample.product.service.CategoryService;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    void testGetCategory_200() throws Exception {

        when(categoryService.findAll()).thenReturn(List.of(Category.builder()
            .principal(CategoryPrincipalEnum.FOOD).name("FEIJAO").id(UUID.randomUUID().toString()).build()));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/category")
                .accept(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpectAll(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$[*].name").value("FEIJAO"));

    }

    @Test
    void testGetCategory_returnValue() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/category")
                .accept(MediaType.APPLICATION_JSON))
            .andExpectAll(status().isOk());

    }

}