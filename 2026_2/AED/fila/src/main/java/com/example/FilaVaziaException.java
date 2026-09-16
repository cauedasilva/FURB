package com.example;

public class FilaVaziaException extends RuntimeException {
    public FilaVaziaException() {
        super("Fila está vazia");
    }

    public FilaVaziaException(String message) {
        super(message);
    }
}