package com.german.ecommerce.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Product not found");
    }
}
