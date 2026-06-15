package com.example;

import java.util.ArrayList;

public class Vendedor extends Funcionario { // flechinha fechada na uml = extends, flechinha aberta não extends
    private double percentualComissao;
    private ArrayList<Venda> vendas;

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) {
        this.percentualComissao = percentualComissao;
    }

    public Vendedor(String nome, double salarioBase, double percentualComissao) {
        super(nome, salarioBase);
        setPercentualComissao(percentualComissao);
        
        this.vendas = new ArrayList<>();
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public void incluirVenda(Venda v) {
        vendas.add(v);
    }

    @Override
    public double calcularSalario() {
        double totalVendas = 0;
        for (Venda v : vendas) {
            totalVendas += v.getValor();
        }
        // Salário base + (soma das vendas * percentual de comissão)
        return this.salarioBase + (totalVendas * (this.percentualComissao / 100));
    }
}
