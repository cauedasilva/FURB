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

        // OBS: o if(p.getProximo() != null) original ficava fora do
        // if(p != null), causando NullPointerException quando o valor
        // não era encontrado na lista. Movido para dentro para corrigir.
        if (p != null) {
            if (primeiro == p) {
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }

            if (p.getProximo() != null) {
                p.getProximo().setAnterior(p.getAnterior());
            }
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> p = this.primeiro;
        NoListaDupla<T> ultimo;

        while (p != null) {
            if (p.getProximo() == null) {
                ultimo = p;
                while (ultimo != null) {
                    System.out.println(ultimo.getInfo());
                    ultimo = ultimo.getAnterior();
                }
            }

            p = p.getProximo();
        }
    }

    public void liberar() {
        NoListaDupla<T> p = this.primeiro;

        while (p != null) {
            NoListaDupla<T> proximo = p.getProximo();
            p.setProximo(null);
            p.setAnterior(null);
            p = proximo;
        }

        primeiro = null;
    }

    @Override
    public String toString() {
        String resultado = "";
        NoListaDupla<T> p = this.primeiro;

        while (p != null) {
            resultado += p.getInfo();
            if (p.getProximo() != null) {
                resultado += ", ";
            }
            p = p.getProximo();
        }

        return resultado;
    }
}