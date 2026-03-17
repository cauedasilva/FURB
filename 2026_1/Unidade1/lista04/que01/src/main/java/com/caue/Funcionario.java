package com.caue;

public class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        setNome(nome);
        setSalario(salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario <= 0) {
            throw new IllegalArgumentException("Salário deve ser maior que Zero");
        }

        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank() || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public FaixaIrpf identicarFaixaIrpf() {
        FaixaIrpf[] faixas = FaixaIrpf.values();
        double[] limite = {1903.98, 2826.65, 3751.05, 4664.68};
    
        for (int i = 0; i < limite.length; i++) {
            if (salario <= limite[i]) {
                return faixas[i];
            }
        }

        return faixas[faixas.length - 1];
    }
    
    public double calcularIrpf() {
        double valorImposto = 0;
        double salarioTemp = this.salario;
        double valorTaxavel = 0;
        double limiteAnterior = 0;

        double[] imposto = {0, 7.5, 15, 22.5, 27.5};
        double[] limite = {1903.98, 2826.65, 3751.05, 4664.68};

        if (salarioTemp <= 1903.98) {
            return valorImposto;
        }

        for (int i = 0; i < imposto.length; i++) {
            if (salarioTemp > limite[i]) {
                valorTaxavel = limite[i] - limiteAnterior;
                valorImposto += (valorTaxavel * imposto[i]) / 100;
                limiteAnterior = limite[i];
            } else {
                valorTaxavel = salarioTemp - limiteAnterior;
                valorImposto += (valorTaxavel * imposto[i]) / 100;
                return valorImposto;
            }
        }

        return valorImposto;

    }
}
