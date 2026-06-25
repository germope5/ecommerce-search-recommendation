package com.german.ecommerce.exception;

public class ProductNotFoundException extends RuntimeException {

    //Constructor vacio
    public ProductNotFoundException() {
        super("Product not found");
    }


    public ProductNotFoundException(String message) {
        super(message);
    }
}
