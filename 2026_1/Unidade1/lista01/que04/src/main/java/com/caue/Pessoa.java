package com.caue;

public class Pessoa {
    double peso;
    double altura;
    String nome;
    double imc;

    public double calcularImc() {
        return peso / (altura * 2);
    }
}
