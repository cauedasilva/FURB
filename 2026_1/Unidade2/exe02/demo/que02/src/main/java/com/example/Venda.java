package com.example;

public class Venda {
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Venda(double valor) {
        setValor(valor);
    }
}
