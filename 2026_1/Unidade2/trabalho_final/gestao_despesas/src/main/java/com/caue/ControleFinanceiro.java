package com.caue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class ControleFinanceiro extends Lancamento {

    private ArrayList<Lancamento> lancamentos;

    public ControleFinanceiro(String descricao, double valor, LocalDate data) {
        super(descricao, valor, data);
        this.lancamentos = new ArrayList<>();
    }

    // Construtor de conveniência: na prática, ControleFinanceiro é usado
    // como um "gerenciador" e não como um lançamento individual.
    public ControleFinanceiro() {
        this("Controle Financeiro Geral", 0.0, LocalDate.now());
    }

    public void adicionarReceita(Receita receita) {
        lancamentos.add(receita);
    }

    public void adicionarDespesa(Despesa despesa) {
        lancamentos.add(despesa);
    }

    // Método auxiliar fora do diagrama original, necessário para a GUI remover itens
    public void removerLancamento(Lancamento lancamento) {
        lancamentos.remove(lancamento);
    }

    // -------------------------------------------------------------------------
    // Consultas
    // -------------------------------------------------------------------------
    public ArrayList<Receita> listarReceitas() {
        ArrayList<Receita> receitas = new ArrayList<>();
        for (Lancamento l : lancamentos) {
            if (l instanceof Receita) {
                receitas.add((Receita) l);
            }
        }
        return receitas;
    }

    public ArrayList<Despesa> listarDespesas() {
        ArrayList<Despesa> despesas = new ArrayList<>();
        for (Lancamento l : lancamentos) {
            if (l instanceof Despesa) {
                despesas.add((Despesa) l);
            }
        }
        return despesas;
    }

    public ArrayList<Lancamento> listarLancamentos() {
        return new ArrayList<>(lancamentos);
    }

    // Extrato ordenado por data, com saldo acumulado linha a linha
    public ArrayList<ExtratoItem> obterExtratoOrdenado() {
        ArrayList<Lancamento> ordenados = new ArrayList<>(lancamentos);
        ordenados.sort(Comparator.comparing(Lancamento::getData));

        ArrayList<ExtratoItem> extrato = new ArrayList<>();
        double saldoAcumulado = 0.0;

        for (Lancamento l : ordenados) {
            saldoAcumulado += calcularImpacto(l);
            extrato.add(new ExtratoItem(l.getData(), l.getDescricao(), l.getValor(), saldoAcumulado));
        }
        return extrato;
    }

    // Saldo considerando apenas lançamentos já ocorridos (data <= hoje)
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

    // Saldo considerando TODOS os lançamentos cadastrados, mesmo futuros
    public double consultarSaldoTotal() {
        double saldo = 0.0;
        for (Lancamento l : lancamentos) {
            saldo += calcularImpacto(l);
        }
        return saldo;
    }

    // -------------------------------------------------------------------------
    // Implementação do método abstrato herdado de Lancamento
    // -------------------------------------------------------------------------
    @Override
    public double diferencaSaldo() {
        return consultarSaldoTotal();
    }

    // -------------------------------------------------------------------------
    // Auxiliar interno
    // -------------------------------------------------------------------------
    private double calcularImpacto(Lancamento l) {
        if (l instanceof Receita) {
            return ((Receita) l).impactoSaldo();
        } else if (l instanceof Despesa) {
            return ((Despesa) l).impactoSaldo();
        }
        return 0.0;
    }
}
