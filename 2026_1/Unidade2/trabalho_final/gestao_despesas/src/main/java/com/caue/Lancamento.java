package com.caue;

import java.time.LocalDate;

public abstract class Lancamento {
    private String descricao;
    private double valor;
    private LocalDate data;

    public Lancamento(String descricao, double valor, LocalDate data) {
        setDescricao(descricao);
        setValor(valor);
        setData(data);
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isBlank()) {
            throw new IllegalArgumentException("");
        }

        this.descricao = descricao;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("");
        }

        this.valor = valor;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("");
        }

        this.data = data;
    }

    public abstract double diferencaSaldo();
}
