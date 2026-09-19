package com.example;

public class ListaEncadeada<T> {
    private NoLista<T> primeiro;
    private NoLista<T> ultimo;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public NoLista<T> getUltimo() {
        return ultimo;
    }

    public void inserir(T valor) {
        NoLista<T> novo = new NoLista<T>();
        novo.setInfo(valor);
        novo.setProximo(this.primeiro);
        if (estaVazia()) {
            ultimo = novo;
        }

        this.primeiro = novo;
    }

    public void inserirNoFinal(T valor) {
        NoLista<T> novo = new NoLista<T>();
        novo.setInfo(valor);
        novo.setProximo(null);

        if (estaVazia()) {
            primeiro = novo;
        } else {
            ultimo.setProximo(novo);
        }

        ultimo = novo;
    }

    public boolean estaVazia() {
        return this.primeiro == null;
    }

    public NoLista<T> buscar(T valor) {
        NoLista<T> p = this.primeiro;

        while (p != null) {
            if (p.getInfo().equals(valor)) {
                return p;
            }
            p = p.getProximo();
        }

        return null;
    }

    public void retirar(T valor) {
        NoLista<T> anterior = null;
        NoLista<T> p = this.primeiro;

        while (p != null && !p.getInfo().equals(valor)) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p == this.primeiro) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }

        if (p == this.ultimo) {
            this.ultimo = anterior;
        }

    }

    public int obterComprimento() {
        NoLista<T> p = this.primeiro;
        int comp = 0;

        while (p != null) {
            comp++;
            p = p.getProximo();
        }

        return comp;
    }

    public NoLista<T> obterNo(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException("Index negativo: " + idx);
        }

        NoLista<T> p = this.primeiro;
        int comp = 0;

        while (p != null) {
            if (comp == idx) {
                return p;
            }
            comp++;
            p = p.getProximo();
        }

        throw new IndexOutOfBoundsException("Index maior que o comprimento da lista: " + idx);
    }

    @Override
    public String toString() {
        NoLista<T> p = this.primeiro;
        String resultado = "";

        while (p != null) {
            resultado += p.getInfo();
            if (p.getProximo() != null) {
                resultado += ",";
            }
            p = p.getProximo();
        }

        return resultado;
    }
}