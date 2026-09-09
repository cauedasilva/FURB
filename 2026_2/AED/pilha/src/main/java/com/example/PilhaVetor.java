package com.example;

public class PilhaVetor<T> implements Pilha<T> {
    private Object[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        info = new Object[limite];
    }
}
