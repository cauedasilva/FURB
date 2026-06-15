package com.example;

import java.util.ArrayList;


public class Cliente {
    private String nome;
    private ArrayList<Ativo> carteira;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isBlank()) {
            throw new IllegalArgumentException("Valor para o campo nome está incorreto");
        }
        this.nome = nome;
    }

    public Cliente(String nome) {
        this.carteira = new ArrayList<>();
        setNome(nome);
    }

    public void adicionarAtivo(Ativo ativo) {
        if (ativo == null) {
            throw new IllegalArgumentException("Valor para o campo ativo está incorreto");
        }
        carteira.add(ativo);
    }

    public void removerAtivo(Ativo ativo) {
        if (ativo == null) {
            throw new IllegalArgumentException("Valor para o campo ativo está incorreto");
        }
        carteira.remove(ativo);
    }

    public ArrayList<Ativo> getCarteira() {
        return carteira;
    }

    public double calcularRendimentoCarteira() {
        double totalRendimento = 0;
        for (Ativo ativo : carteira) {
            totalRendimento += ativo.calcularRendimento();
        }
        return totalRendimento;
    }

    public double calcularValorInvestido() {
        double totalInvestido = 0;
        for (Ativo ativo : carteira) {
            totalInvestido += ativo.calcularValorInvestido();
        }
        return totalInvestido;
    }

    public double calcularValorCarteira() {
        double totalCarteira = 0;
        for (Ativo ativo : carteira) {
            totalCarteira += ativo.calcularValorBruto();
        }
        return totalCarteira;
    }

}
