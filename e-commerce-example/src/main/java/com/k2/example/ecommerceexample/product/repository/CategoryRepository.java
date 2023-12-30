package com.k2.example.ecommerceexample.product.repository;

import com.k2.example.ecommerceexample.product.model.Category;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {

    Optional<Category> findByName(String category);
}
