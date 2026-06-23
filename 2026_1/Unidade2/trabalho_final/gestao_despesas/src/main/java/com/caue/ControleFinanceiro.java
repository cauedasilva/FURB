package com.caue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class ControleFinanceiro extends Lancamento {
    private ArrayList<Lancamento> lancamentos;

    /**
     * Método constructor da classe ControleFinanceiro
     * @param descricao descrição a ser adicionada
     * @param valor valor a ser adicionado
     * @param data data a ser adicionada
     */
    public ControleFinanceiro(String descricao, double valor, LocalDate data) {
        super(descricao, valor, data);
        this.lancamentos = new ArrayList<>();
    }

    /**
     * Método constructor com valores padrões para não precisar popular os dados sempre
     */
    public ControleFinanceiro() {
        this("Controle Financeiro", 0.0, LocalDate.now());
    }

    /**
     * Método adicionarReceita adiciona uma receita ao Array de lançamentos
     * @param receita receita a ser adicionada
     */
    public void adicionarReceita(Receita receita) {
        lancamentos.add(receita);
    }

    /**
     * Método adicionarDespesa adiciona uma despesa ao Array de lançamentos
     * @param despesa despesa a ser adicionada
     */
    public void adicionarDespesa(Despesa despesa) {
        lancamentos.add(despesa);
    }

    /**
     * Método removerLancamento remove um lançamento da array de lançamentos
     * @param lancamento lançamento a ser removido
     */
    public void removerLancamento(Lancamento lancamento) {
        lancamentos.remove(lancamento);
    }

    /**
     * Método listarLancamentos retorna todos os lançamentos 
     * @return todos os lançamentos por uma array
     */
    public ArrayList<Lancamento> listarLancamentos() {
        return new ArrayList<>(lancamentos);
    }

    /**
     * Método obterExtratoOrdenado ordena todos os lançamentos em uma nova array por data de adição, e com o cálculo do saldo
     * @return array de extrato ordenado
     */
    public ArrayList<ExtratoItem> obterExtratoOrdenado() {
        ArrayList<Lancamento> ordenados = new ArrayList<>(lancamentos);
        Collections.sort(ordenados);
        
        ArrayList<ExtratoItem> extrato = new ArrayList<>();
        double saldoAcumulado = 0.0;

        for (Lancamento l : ordenados) {
            saldoAcumulado += calcularImpacto(l);
            extrato.add(new ExtratoItem(l.getData(), l.getDescricao(), l.getValor(), saldoAcumulado));
        }
        return extrato;
    }

    /**
     * Método consultarSaldoAtual consulta o saldo considerando todos os lançamentos antes da data atual
     * @return double saldo do cálculo do saldo 
     */
    public double consultarSaldoAtual() {
        LocalDate hoje = LocalDate.now();
        double saldo = 0.0;
        for (Lancamento l : lancamentos) {
            if (!l.getData().isAfter(hoje)) {
                saldo += calcularImpacto(l);
            }
        }
        return saldo;
    }

    /**
     * Método consultarSaldoTotal consulta o saldo considerando todos os lançamentos, mesmo futuros
     * @return double do cálculo do saldo
     */
    public double consultarSaldoTotal() {
        double saldo = 0.0;
        for (Lancamento l : lancamentos) {
            saldo += calcularImpacto(l);
        }
        return saldo;
    }

    /**
     * Método calcularImpacto define se o lancamento é uma despesa ou receita e retorna o impacto no saldo considerandos as diferenças no cálculo   
     * @param l lancamento a ser avaliado   
     * @return double do impacto que o lancamento terá no saldo
     */
    private double calcularImpacto(Lancamento l) {
        if (l instanceof Receita) {
            return ((Receita) l).impactoSaldo();
        } else if (l instanceof Despesa) {
            return ((Despesa) l).impactoSaldo();
        }
        return 0.0;
    }
}
