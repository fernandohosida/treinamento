package com.k2.example.ecommerceexample.product.repository;

import com.k2.example.ecommerceexample.product.model.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    public Optional<Product> findByName(String name);
}
