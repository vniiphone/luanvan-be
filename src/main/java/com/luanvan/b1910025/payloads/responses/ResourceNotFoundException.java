package com.luanvan.b1910025.payloads.responses;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID 	= 1L;
    public ResourceNotFoundException(String message) {
        super(message);
    }
}