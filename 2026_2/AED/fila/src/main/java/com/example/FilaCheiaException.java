package com.example;

public class FilaCheiaException extends RuntimeException {
    public FilaCheiaException() {
        super("Capacidade esgotada da fila");
    }

    public FilaCheiaException(String message) {
        super(message);
    }
}