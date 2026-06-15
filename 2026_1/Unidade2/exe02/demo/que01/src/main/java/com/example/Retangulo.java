package com.example;

public class Retangulo extends Figura {
    private int largura;
    private int altura;

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public Retangulo(int largura, int altura) {
        setAltura(altura);
        setLargura(largura);
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}
