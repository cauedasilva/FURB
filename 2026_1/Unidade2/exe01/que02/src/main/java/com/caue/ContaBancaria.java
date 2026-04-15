package com.caue;

import java.util.ArrayList;

public class ContaBancaria {
    private String numero;
    private double saldo;
    private Cliente titular;
    private ArrayList<Movimento> movimentos = new ArrayList<>();

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

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public ArrayList<Movimento> getMovimento() {
        return movimentos;
    }

    protected void incluirMovimento(Movimento m) {
        movimentos.add(m);
    }

    public ContaBancaria(String numero, double saldo, Cliente titular) {
        setNumero(numero);
        setSaldo(saldo);
        setTitular(titular);
    }

    public void depositar(double valor, TipoMovimento tipoMovimento) {
        setSaldo(valor);
        Movimento movimento = new Movimento(valor, tipoMovimento);
        incluirMovimento(movimento);
    }

    public void sacar(double valor, TipoMovimento tipoMovimento) {
        setSaldo(saldo - valor);
        Movimento movimento = new Movimento(valor, tipoMovimento);
        incluirMovimento(movimento);
    }

    public void transferir(ContaBancaria contaDestino, double valor, TipoMovimento tipoMovimento) {
        sacar(valor, tipoMovimento);
        contaDestino.depositar(valor, tipoMovimento);
    }
}
