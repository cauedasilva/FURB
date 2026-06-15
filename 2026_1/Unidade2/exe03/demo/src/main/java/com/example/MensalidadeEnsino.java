package com.example;

public class MensalidadeEnsino implements Pagavel {
    int nrCreditos;
    double precoCredito;

    public int getNrCreditos() {
        return nrCreditos;
    }

    public void setNrCreditos(int nrCreditos) {
        this.nrCreditos = nrCreditos;
    }

    public double getPrecoCredito() {
        return precoCredito;
    }

    public void setPrecoCredito(double precoCredito) {
        this.precoCredito = precoCredito;
    }

    public MensalidadeEnsino(int nrCreditos, double precoCredito) {
        setNrCreditos(nrCreditos);
        setPrecoCredito(precoCredito);
    }

    @Override
    public double calcularValorPagar() {
        return getNrCreditos() * getPrecoCredito();
    }

}
