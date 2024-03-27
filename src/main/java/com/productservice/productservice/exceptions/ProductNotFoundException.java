package com.productservice.productservice.exceptions;

public class ProductNotFoundException extends Exception{ // This is our Custom Exception Class. Note: Always create Custom Exceptions
    public ProductNotFoundException(String message){
        super(message);
    }
}
