package com.caue;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControleFinanceiroTest {

    private ControleFinanceiro controle;

    @BeforeEach
    void setup() {
        controle = new ControleFinanceiro();
    }

    @Test
    void deveAdicionarReceita() {
        Receita receita = new Receita(
                "Salário",
                3000,
                LocalDate.now(),
                CategoriaReceita.SALARIO);

        controle.adicionarReceita(receita);

        assertEquals(1, controle.listarLancamentos().size());
    }

    @Test
    void deveAdicionarDespesa() {
        Despesa despesa = new Despesa(
                "Mercado",
                200,
                LocalDate.now(),
                CategoriaDespesa.ALIMENTACAO);

        controle.adicionarDespesa(despesa);

        assertEquals(1, controle.listarLancamentos().size());
    }

    @Test
    void deveRemoverLancamento() {
        Receita receita = new Receita(
                "Salário",
                3000,
                LocalDate.now(),
                CategoriaReceita.SALARIO);

        controle.adicionarReceita(receita);
        controle.removerLancamento(receita);

        assertTrue(controle.listarLancamentos().isEmpty());
    }

    @Test
    void deveListarLancamentos() {
        Receita receita = new Receita(
                "Salário",
                3000,
                LocalDate.now(),
                CategoriaReceita.SALARIO);

        controle.adicionarReceita(receita);

        ArrayList<Lancamento> lista = controle.listarLancamentos();

        assertEquals(1, lista.size());
    }

    @Test
    void deveConsultarSaldoTotal() {
        controle.adicionarReceita(
                new Receita("Salário", 3000,
                        LocalDate.now(),
                        CategoriaReceita.SALARIO));

        controle.adicionarDespesa(
                new Despesa("Mercado", 500,
                        LocalDate.now(),
                        CategoriaDespesa.ALIMENTACAO));

        assertEquals(2500, controle.consultarSaldoTotal());
    }

    @Test
    void deveConsultarSaldoAtualIgnorandoLancamentosFuturos() {
        controle.adicionarReceita(
                new Receita("Salário", 3000,
                        LocalDate.now(),
                        CategoriaReceita.SALARIO));

        controle.adicionarReceita(
                new Receita("Bônus", 1000,
                        LocalDate.now().plusDays(5),
                        CategoriaReceita.OUTRAS_RECEITAS));

        assertEquals(3000, controle.consultarSaldoAtual());
    }

    @Test
    void deveGerarExtratoOrdenado() {

        controle.adicionarReceita(
                new Receita("Salário", 3000,
                        LocalDate.of(2025, 1, 10),
                        CategoriaReceita.SALARIO));

        controle.adicionarDespesa(
                new Despesa("Mercado", 500,
                        LocalDate.of(2025, 1, 15),
                        CategoriaDespesa.ALIMENTACAO));

        ArrayList<ExtratoItem> extrato =
                controle.obterExtratoOrdenado();

        assertEquals(2, extrato.size());

        assertEquals(3000,
                extrato.get(0).getSaldoAcumulado());

        assertEquals(2500,
                extrato.get(1).getSaldoAcumulado());
    }
}