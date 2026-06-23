package com.caue;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class LancamentoCsvTest {

    @Test
    void deveSalvarECarregarLancamentos() {

        String arquivo = "teste.csv";

        LancamentoCsv csv = new LancamentoCsv(arquivo);

        ArrayList<Lancamento> lista = new ArrayList<>();

        lista.add(
                new Receita(
                        "Salário",
                        3000,
                        LocalDate.of(2025, 1, 10),
                        CategoriaReceita.SALARIO));

        lista.add(
                new Despesa(
                        "Mercado",
                        500,
                        LocalDate.of(2025, 1, 15),
                        CategoriaDespesa.ALIMENTACAO));

        csv.salvarTodos(lista);

        ArrayList<Lancamento> carregados =
                csv.carregarTodos();

        assertEquals(2, carregados.size());

        assertTrue(carregados.get(0) instanceof Receita);
        assertTrue(carregados.get(1) instanceof Despesa);

        new File(arquivo).delete();
    }
}