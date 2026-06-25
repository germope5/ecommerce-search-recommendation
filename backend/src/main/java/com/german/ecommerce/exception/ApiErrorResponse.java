package com.german.ecommerce.exception;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiErrorResponse {
    private int status;
    private String message;
    private Map<String, String> errors;

    public ApiErrorResponse(){}

    // Errores de negocio,(404,409,etc)
    public ApiErrorResponse(int status, String message){
        this.status = status;
        this.message = message;
    }

    // Errores de validación (400)
    public ApiErrorResponse(int status, Map<String, String> errors){
        this.status = status;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
    

}