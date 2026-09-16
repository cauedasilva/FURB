package com.example;

public class FilaVetor<T> implements Fila<T> {
    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0;
    }

    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }

        int posicaoInserir;
        posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        tamanho--;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        return (T) info[inicio];
    }

    public T retirar() {
        
    }
}
