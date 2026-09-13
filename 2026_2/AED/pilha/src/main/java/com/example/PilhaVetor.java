package com.example;
 
public class PilhaVetor<T> implements Pilha<T> {
    private Object[] info;
    private int limite;
    private int tamanho;
 
    public PilhaVetor(int limite) {
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0;
    }
 
    public void push(T valor) {
        if (tamanho == limite) {
            throw new PilhaCheiaException();
        }
 
        info[tamanho] = valor;
        tamanho++;
    }
 
    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
 
        tamanho--;
        T valor = (T) info[tamanho];
        info[tamanho] = null;
        return valor;
    }

    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
 
        return (T) info[tamanho - 1];
    }
 
    public boolean estaVazia() {
        return tamanho == 0;
    }
 
    public void liberar() {
        while (!estaVazia()) {
            pop();
        }
    }
 
    @Override
    public String toString() {
        String resultado = "";
 
        for (int i = tamanho - 1; i >= 0; i--) {
            resultado += info[i];
            if (i > 0) {
                resultado += ",";
            }
        }
 
        return resultado;
    }
 
    public void concatenar(PilhaVetor<T> p) {
        int qtdP = p.tamanho;
 
        if (this.limite - this.tamanho < qtdP) {
            throw new PilhaCheiaException("Capacidade insuficiente");
        }
 
        for (int i = 0; i < qtdP; i++) {
            this.push((T) p.info[i]);
        }
    }
}
 
