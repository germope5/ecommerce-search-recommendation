package com.german.ecommerce.exception;

public class DuplicateSkuException extends RuntimeException {

    //Constructor vacio
    public DuplicateSkuException() {}
    
    public DuplicateSkuException(String message) {
        super(message);
    }
}
