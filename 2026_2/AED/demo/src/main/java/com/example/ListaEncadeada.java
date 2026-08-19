package com.example;

public class ListaEncadeada<T> {
    private NoLista<T> primeiro;

    public ListaEncadeada() {
        this.primeiro = null;
    }

    public void setPrimeiro(NoLista<T> primeiro) {
        this.primeiro = primeiro;
    }

    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<T>();
        valor = novo.getInfo();
        primeiro = novo.getProximo();
        novo = this.primeiro;
    }

    public boolean estaVazia() {
        if (this.primeiro == null) {
            return true;
        } else {
            return false;
        }
    }

    public NoLista<T> buscar(T valor) {
        NoLista<T> p = new NoLista<T>();
        primeiro = p;

        while (p != null) {
            if (p.getInfo() == valor) {
                return p;
            }
            
            p = p.getProximo();
        }

        return null;
    }
}
