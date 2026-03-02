package com.caue;

public class Pessoa {
    double peso;
    double altura;

    public double calcularImc() {
        return peso / (altura * 2);
    }
}
