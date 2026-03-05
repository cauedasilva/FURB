package com.caue;

public class ContaBancaria {
    private String numero;
    private String titular;
    private double saldo;

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            return;
        }

        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            return;
        } else if (this.saldo - valor < 0) {
            return;
        }

        this.saldo -= valor;
    }

    public void transferir(ContaBancaria contaDestino, double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    }
}
