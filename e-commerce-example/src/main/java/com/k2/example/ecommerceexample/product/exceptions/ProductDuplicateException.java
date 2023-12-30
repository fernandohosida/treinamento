package com.k2.example.ecommerceexample.product.exceptions;

public class ProductDuplicateException extends RuntimeException {

    public ProductDuplicateException() {
        super("Product Already Exists");
    }

    public ProductDuplicateException(String productAlreadyExists) {
        super(productAlreadyExists);
    }
}
