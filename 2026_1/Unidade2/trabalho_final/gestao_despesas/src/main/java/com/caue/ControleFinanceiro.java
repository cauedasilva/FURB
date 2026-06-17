package com.caue;

import java.time.LocalDate;
import java.util.ArrayList;

public class ControleFinanceiro extends Lancamento {

    private ArrayList<Lancamento> lancamentos;

    public ControleFinanceiro(String descricao, double valor, LocalDate data) {
        super(descricao, valor, data);
        this.lancamentos = new ArrayList<>();
    }

    public void adicionarReceita(Receita receita) {
        if (receita == null) {
            throw new IllegalArgumentException("");
        }

        lancamentos.add(receita);
    }

    public void adicionarDespesa(Despesa despesa) {
        if (despesa == null) {
            throw new IllegalArgumentException("");
        }

        lancamentos.add(despesa);
    }

    public ArrayList<Receita> listarReceitas() {
        ArrayList<Receita> receitas = new ArrayList<>();

        for (Lancamento lancamento : lancamentos) {
            if (lancamento instanceof Receita) {
                Receita receita = (Receita) lancamento;
                receitas.add(receita);
            }
        }

        return receitas;
    }

    public ArrayList<Despesa> listarDespesas() {
        ArrayList<Despesa> despesas = new ArrayList<>();

        for (Lancamento lancamento : lancamentos) {
            if (lancamento instanceof Despesa) {
                Despesa despesa = (Despesa) lancamento;
                despesas.add(despesa);
            }
        }

        return despesas;
    }

    public ArrayList<Lancamento> listarLancamentos() {
        for (Lancamento lancamento : lancamentos) {
            // System.out.println(lancamento);
        }
        return null;
    }

    public ArrayList<ExtratoItem> obterExtratoOrdenado() {
        return null;
    }

    public double consultarSaldoAtual() {
        return 0;
    }

    public double consultarSaldoTotal() {
        return 0;
    }

    @Override
    public double diferencaSaldo() {
        return 0;
    }
}
