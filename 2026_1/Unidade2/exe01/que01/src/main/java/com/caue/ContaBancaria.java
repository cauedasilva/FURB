package com.caue;

public class ContaBancaria {
    private String numero;
    private double saldo;
    private Cliente titular;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private Cliente getTitular() {
        return titular;
    }

    private void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public ContaBancaria(String numero, double saldo, Cliente titular) {
        setNumero(numero);
        setSaldo(saldo);
        setTitular(titular);
    }

    public void depositar(double valor) {
        setSaldo(valor);
    }

    public void sacar(double valor) {
        if (this.saldo - valor < 0) {
            return;
        }

        setSaldo(saldo - valor);
    }

    public void transferir(ContaBancaria contaDestino, double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    }
}
