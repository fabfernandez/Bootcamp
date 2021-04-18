package com.example.desafioquality.exceptions;

public class BadParametersException extends RuntimeException{
    public BadParametersException(String error) {
        super(error + ", please refer to API documentation.");
    }
}
