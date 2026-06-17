package com.caue;

import java.time.LocalDate;

public abstract class Lancamento {

    private String descricao;
    private double valor;
    private LocalDate data;

    public Lancamento(String descricao, double valor, LocalDate data) {
    }

    public String getDescricao() {
        return null;
    }

    public void setDescricao(String descricao) {
    }

    public double getValor() {
        return 0;
    }

    public void setValor(double valor) {
    }

    public LocalDate getData() {
        return null;
    }

    public void setData(LocalDate data) {
    }

    public abstract double diferencaSaldo();
}
