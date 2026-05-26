package com.example;

public class Acao implements Ativo {
    private int qtdCota;
    private double valorCota;
    private double rentabilidade;

    public double getRentabilidade() {
        return rentabilidade;
    }
    public void setRentabilidade(double rentabilidade) {
        if (rentabilidade <= 0) {
            throw new IllegalArgumentException("Valor para o campo rentabilidade está incorreto");
        }
        this.rentabilidade = rentabilidade;
    }
    public int getQtdCota() {
        return qtdCota;
    }
    public void setQtdCota(int qtdCota) {
        if (qtdCota <= 0) {
            throw new IllegalArgumentException("Valor para o campo qtdCota está incorreto");
        }
        this.qtdCota = qtdCota;
    }
    public double getValorCota() {
        return valorCota;
    }
    public void setValorCota(double valorCota) {
        if (valorCota <= 0) {
            throw new IllegalArgumentException("Valor para o campo valorCota está incorreto");
        }
        this.valorCota = valorCota;
    }

    public Acao(int qtdCota, double valorCota, double rentabilidade) {
        setQtdCota(qtdCota);
        setRentabilidade(rentabilidade);
        setValorCota(valorCota);
    }

    public double calcularRendimento() {
        return calcularValorInvestido() * (getRentabilidade() / 100); 
    }

    public double calcularValorInvestido() {
        return getQtdCota() * getValorCota();
    }

    public double calcularValorBruto() {
        return calcularValorInvestido() + calcularRendimento();
    }
    
}
