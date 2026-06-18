package com.german.ecommerce.exception;

public class DuplicateSkuException extends RuntimeException {

    public DuplicateSkuException() {
        super("SKU already exists");
    }
}
