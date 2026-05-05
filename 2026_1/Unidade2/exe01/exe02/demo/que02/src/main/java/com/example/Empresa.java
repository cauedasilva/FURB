package com.example;

import java.util.ArrayList;

public class Empresa {
    private String nome;
    private ArrayList<Funcionario> funcionarios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Empresa(String nome) {
        setNome(nome);
    }

    public void incluirFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public void removerFuncionario(Funcionario f) {
        funcionarios.remove(f);
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public double calcularCustosSalarios() {
        double total = 0;
        for (Funcionario f : funcionarios) {
            // O polimorfismo decide em tempo de execução qual 
            // calcularSalario() chamar (do Programador ou do Vendedor)
            total += f.calcularSalario(); 
        }
        return total;
    }
}
