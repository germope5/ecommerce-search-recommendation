package com.german.ecommerce.exception;

public class ProductNotFoundException extends RuntimeException {

    //Constructor vacio
    public ProductNotFoundException() {}


    public ProductNotFoundException(String message) {
        super(message);
    }
}
