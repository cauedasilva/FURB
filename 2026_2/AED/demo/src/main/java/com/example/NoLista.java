package com.example;

public class NoLista<T> {
    private NoLista<T> proximo;
    private T info;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoLista<T> getProximo() {
        return proximo;
    }
    
    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }

}
