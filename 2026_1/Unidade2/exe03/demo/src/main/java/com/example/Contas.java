package com.example;

import java.util.ArrayList;

public class Contas {
    private ArrayList<Pagavel> contas;

    public void incluirConta(Pagavel conta) {
        contas.add(conta);
    }

    public ArrayList<Pagavel> getContas() {
        return contas;
    }

    public double calcularTotalContas() {
        double totalContas = 0;
        for (Pagavel c : contas ) {
            totalContas += c.calcularValorPagar();
        }
        return totalContas;
    }
}
