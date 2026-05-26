package com.example;

public class FundoImobiliario extends Acao {
    private double dividendo;

    public double getDividendo() {
        return dividendo;
    }

    public void setDividendo(double dividendo) {
        if (dividendo <= 0) {
            throw new IllegalArgumentException("Valor para o campo dividendo está incorreto");
        }
        this.dividendo = dividendo;
    }

    public FundoImobiliario(int qtdCota, double valorCota, double rentabilidade, double dividendo) {
        super(qtdCota, valorCota, rentabilidade);
        setDividendo(dividendo);
    }

    public double calcularRendimento() {
        return getQtdCota() * getDividendo();
    }
}
