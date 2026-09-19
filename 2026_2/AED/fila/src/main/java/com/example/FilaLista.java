package com.example;

public class FilaLista<T> implements Fila<T> {
    private ListaEncadeada<T> lista = new ListaEncadeada<T>();

    public void inserir(T valor) {
        lista.inserirNoFinal(valor);
    }

    public boolean estaVazia() {
        return lista.estaVazia();
    }

    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }
        
        return lista.getPrimeiro().getInfo();

    }

    public T retirar() {
        T valor;
        valor = peek();
        lista.retirar(valor);

        return valor;
    }

    public void liberar() {
        while (!estaVazia()) {
            retirar();
        }
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
