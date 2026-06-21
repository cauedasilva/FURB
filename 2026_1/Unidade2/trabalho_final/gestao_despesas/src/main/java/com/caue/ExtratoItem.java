package com.caue;

import java.time.LocalDate;

public class ExtratoItem {
    private LocalDate data;
    private String descricao;
    private double valor;
    private double saldoAcumulado;

    /**
     * Método constructor da classe ExtratoItem
     * @param data a ser definido  
     * @param descricao a ser definido
     * @param valor a ser definido
     * @param saldoAcumulado a ser definido
     */
    public ExtratoItem(LocalDate data, String descricao, double valor, double saldoAcumulado) {
        setData(data);  
        setDescricao(descricao);
        setValor(valor);
        setSaldoAcumulado(saldoAcumulado);
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
     * @param data a ser definido
     */
    public void setData(LocalDate data) {
        this.data = data;
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
     * @param valor a ser definido
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Método getter do atributo saldoAcumulado
     * @return double saldoAcumulado
     */
    public double getSaldoAcumulado() {
        return saldoAcumulado;
    }

    /**
     * Método setter do atributo saldoAcumulado
     * @param saldoAcumulado a ser definido
     */
    public void setSaldoAcumulado(double saldoAcumulado) {
        this.saldoAcumulado = saldoAcumulado;
    }
}
