package com.caue;

public class Pessoa {
    private double peso;
    private double altura;
    private String nome;
    private double imc;

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getImc() {
        return this.imc;
    }

    public double calcularImc() {
        return peso / (altura * 2);
    }

}