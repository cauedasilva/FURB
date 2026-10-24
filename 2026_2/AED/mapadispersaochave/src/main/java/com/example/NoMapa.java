package com.example;

public class NoMapa<K, T> {
    private K chave;
    private T valor;

    public NoMapa(K chave, T valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NoMapa<?, ?> outro = (NoMapa<?, ?>) o;
        return chave.equals(outro.chave);
    }

    @Override
    public int hashCode() {
        return chave.hashCode();
    }
}
