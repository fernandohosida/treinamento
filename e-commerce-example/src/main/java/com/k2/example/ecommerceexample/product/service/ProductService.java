package com.k2.example.ecommerceexample.product.service;

import com.k2.example.ecommerceexample.product.exceptions.ProductDuplicateException;
import com.k2.example.ecommerceexample.product.model.Category;
import com.k2.example.ecommerceexample.product.model.Product;
import com.k2.example.ecommerceexample.product.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {

        verifySameProduct(product);

        product.setCreated_at(LocalDateTime.now());
        return productRepository.save(product);
    }

    private void verifySameProduct(Product product) {
         if (productRepository.findByName(product.getName()).isPresent()) {
             throw new ProductDuplicateException("Product already exists");
         }
    }

    public List<Product> findAll() {

        return productRepository.findAll();
    }

    public Category findCategory(String category) {
        return categoryService.findCategory(category);
    }
}
