package com.company.exceptions;

public class InsufficientAmountOfItemsException extends Exception {
    public InsufficientAmountOfItemsException(String message) {
        super(message);
    }
}
