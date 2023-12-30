package com.k2.example.ecommerceexample.product.controller;

import com.k2.example.ecommerceexample.product.dto.ProductDto;
import com.k2.example.ecommerceexample.product.model.Product;
import com.k2.example.ecommerceexample.product.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<ProductDto> postProduct(@RequestBody ProductDto post) {
        Product product = Product.builder()
            .name(post.name())
            .category(productService.findCategory(post.category()))
            .price(post.value())
            .build();

        Product response = productService.save(product);

        ProductDto productDto = new ProductDto(response.getId().toString(),
            response.getName(),
            response.getCategory().getName(),
            response.getPrice(),
            response.getCreated_at());

        return ResponseEntity.ok(productDto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {

        List<Product> products = productService.findAll();

        List<ProductDto> productDtos = products.stream().map(a -> produtoToDto(a)).toList();
        return ResponseEntity.ok(productDtos);
    }

    private ProductDto produtoToDto(Product a) {
        return new ProductDto(a.getId().toString(), a.getName(), a.getCategory().getName(), a.getPrice(), a.getCreated_at());
    }

}

