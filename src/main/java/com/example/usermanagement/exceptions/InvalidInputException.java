package com.example.usermanagement.exceptions;

public class InvalidInputException  extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}