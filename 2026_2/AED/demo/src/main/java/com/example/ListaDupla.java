package com.example;

public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<T>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }

        primeiro = novo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> p = primeiro;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }

        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> p = buscar(valor);

        if (p != null) {
            if (primeiro == p) {
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }
        }

        if (p.getProximo() != null) {
            p.getProximo().setAnterior(p.getAnterior());
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> p = this.primeiro;
        NoListaDupla<T> ultimo;

        while (p != null) {
            if (p.getProximo() == null) {
                ultimo = p;
                while (ultimo.getAnterior() != null)) {
                    System.out.println(ultimo.toString());
                    ultimo = ultimo.getAnterior();
                }
            }

            p = p.getProximo();
        }
    }

    public void liberar() {
        NoListaDupla<T> p = this.primeiro;

        while (p != null) {

            p = p.getProximo();
        }
    }
}
