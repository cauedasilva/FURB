package com.example;

public abstract class Investimento implements Pagavel {
    private double saldo;

    public double getSaldo() {
        return this.saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
