package com.example;

public class ContaAgua implements Pagavel {
    private int metrosCubicos;
    private double precoMetroCubico;

    public int getMetrosCubicos() {
        return metrosCubicos;
    }

    public void setMetrosCubicos(int metrosCubicos) {
        this.metrosCubicos = metrosCubicos;
    }

    public double getPrecoMetroCubico() {
        return precoMetroCubico;
    }

    public void setPrecoMetroCubico(double precoMetroCubico) {
        this.precoMetroCubico = precoMetroCubico;
    }

    public ContaAgua(int metrosCubicos, double precoMetroCubico) {
        setMetrosCubicos(metrosCubicos);
        setPrecoMetroCubico(precoMetroCubico);
    }

    @Override
    public double calcularValorPagar() {
        return getPrecoMetroCubico() * getMetrosCubicos();
    }
}
