package com.example;

public class Circulo extends Figura {
    private int raio;

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public Circulo(int raio) {
        setRaio(raio);
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(raio, raio);
    }
}
