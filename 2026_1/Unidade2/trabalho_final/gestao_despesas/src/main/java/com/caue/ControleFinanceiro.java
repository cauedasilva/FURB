package com.caue;

import java.time.LocalDate;
import java.util.List;

public class ControleFinanceiro extends Lancamento {

    private List<Lancamento> lancamentos;

    public ControleFinanceiro(String descricao, double valor, LocalDate data) {
        super(descricao, valor, data);
    }

    public void adicionarReceita(Receita receita) {
    }

    public void adicionarDespesa(Despesa despesa) {
    }

    public List<Receita> listarReceitas() {
        return null;
    }

    public List<Despesa> listarDespesas() {
        return null;
    }

    public List<Lancamento> listarLancamentos() {
        return null;
    }

    public List<ExtratoItem> obterExtratoOrdenado() {
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
