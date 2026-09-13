package com.example;

public class PilhaLista<T> implements Pilha<T> {
    private ListaEncadeada<T> lista = new ListaEncadeada<T>();

    public void push(T info) {
        lista.inserir(info);
    }

    public T pop() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        T valor = lista.getPrimeiro().getInfo();
        lista.retirar(valor);
        return valor;
    }

    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }

        return lista.getPrimeiro().getInfo();
    }

    public boolean estaVazia() {
        return lista.estaVazia();
    }

    public void liberar() {
        while (!estaVazia()) {
            pop();
        }
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}