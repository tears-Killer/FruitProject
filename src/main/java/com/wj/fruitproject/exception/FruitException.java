package com.wj.fruitproject.exception;

public class FruitException extends RuntimeException {

    public String message;

    public FruitException(String message) {
        super(message);
    }
}
