package com.german.ecommerce.exception;

public class DuplicateSkuException extends RuntimeException {

    //Constructor vacio
    public DuplicateSkuException() {
            super("SKU already exists");

    }
    
    public DuplicateSkuException(String message) {
        super(message);
    }
}
