package com.luanvan.b1910025.payloads.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Object fieldValue;
    private static final long serialVersionUID 	= 1L;
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}