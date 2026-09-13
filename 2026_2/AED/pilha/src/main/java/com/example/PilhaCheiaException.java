package com.example;

public class PilhaCheiaException extends RuntimeException {
    public PilhaCheiaException() {
        super("Capacidade esgotada da pilha");
    }

    public PilhaCheiaException(String message) {
        super(message);
    }
}