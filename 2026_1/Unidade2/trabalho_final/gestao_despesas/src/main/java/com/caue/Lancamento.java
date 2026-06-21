package com.caue;

import java.time.LocalDate;

public abstract class Lancamento {

    private String descricao;
    private double valor;
    private LocalDate data;

    public Lancamento(String descricao, double valor, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    // -------------------------------------------------------------------------
    // Método abstrato — cada subclasse define como impacta o saldo
    // -------------------------------------------------------------------------
    public abstract double diferencaSaldo();
}
