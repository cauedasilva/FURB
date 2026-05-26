package com.example;

public class TesouroDireto implements Ativo {
    private double valor;
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
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor para o campo valor está incorreto");
        }
        this.valor = valor;
    }

    public TesouroDireto(double valor, double rentabilidade) {
        setRentabilidade(rentabilidade);
        setValor(valor);
    }
    
    public double calcularRendimento() {
        return calcularValorInvestido() * (getRentabilidade() / 100);
    }

    public double calcularValorBruto() {
        return calcularValorInvestido() + calcularRendimento();
    }

    public double calcularValorInvestido() {
        return getValor();
    }

}
