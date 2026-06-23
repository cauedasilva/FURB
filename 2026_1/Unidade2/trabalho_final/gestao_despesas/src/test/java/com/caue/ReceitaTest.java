package com.caue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ReceitaTest {

    @Test
    void deveRetornarValorPositivoNoImpactoSaldo() {
        Receita receita = new Receita(
                "Salário",
                3000.0,
                LocalDate.now(),
                CategoriaReceita.SALARIO);

        assertEquals(3000.0, receita.impactoSaldo());
    }
}