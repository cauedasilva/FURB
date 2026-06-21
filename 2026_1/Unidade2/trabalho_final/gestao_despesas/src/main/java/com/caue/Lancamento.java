package com.caue;

import java.time.LocalDate;

public abstract class Lancamento {
    private String descricao;
    private double valor;
    private LocalDate data;

    /**
     * Método constructor da classe Lancamento
     * @param descricao a ser definida
     * @param valor a ser definido
     * @param data a ser definido
     */
    public Lancamento(String descricao, double valor, LocalDate data) {
        setDescricao(descricao);
        setValor(valor);
        setData(data);
    }

    /**
     * Método getter do atributo descricao
     * @return String descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método setter do atributo descricao
     * @param descricao a ser definido
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Método getter do atributo valor
     * @return double valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * Método setter do atributo valor
     * @param valor a ser valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Método getter do atributo data
     * @return LocalDate data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Método setter do atributo data
     * @param data a ser definida
     */
    public void setData(LocalDate data) {
        this.data = data;
    }
}
