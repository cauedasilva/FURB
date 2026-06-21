package com.caue;

import java.time.LocalDate;

public class ExtratoItem {
    private LocalDate data;
    private String descricao;
    private double valor;
    private double saldoAcumulado;

    public ExtratoItem(LocalDate data, String descricao, double valor, double saldoAcumulado) {
        setData(data);  
        setDescricao(descricao);
        setValor(valor);
        setSaldoAcumulado(saldoAcumulado);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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

    public double getSaldoAcumulado() {
        return saldoAcumulado;
    }

    public void setSaldoAcumulado(double saldoAcumulado) {
        this.saldoAcumulado = saldoAcumulado;
    }
}
