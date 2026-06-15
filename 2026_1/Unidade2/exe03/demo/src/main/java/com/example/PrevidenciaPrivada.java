package com.example;

public class PrevidenciaPrivada extends Investimento {
    private double valor;

    @Override
    public double calcularValorPagar() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void investir() {
        setSaldo(getSaldo() + this.valor);
    }
}

