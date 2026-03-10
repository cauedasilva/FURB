package com.caue;

public class ContaBancaria {
    private String numero;
    private String titular;
    private double saldo;

    public void setNumero(String numero) {
        if (numero == null || numero.isEmpty() || numero.isBlank()) {
            throw new IllegalArgumentException("Número inválido");
        }

        this.numero = numero.trim();
    }

    public String getNumero() {
        return this.numero;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.isEmpty() || titular.isBlank()) {
            throw new IllegalArgumentException("Titular inválido");
        }

        this.titular = titular.trim();
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0 || this.saldo - valor < 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        this.saldo -= valor;
    }

    public void transferir(ContaBancaria contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
}

