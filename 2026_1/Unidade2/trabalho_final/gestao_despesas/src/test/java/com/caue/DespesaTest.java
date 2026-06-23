package com.caue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class DespesaTest {

    @Test
    void deveRetornarValorNegativoNoImpactoSaldo() {
        Despesa despesa = new Despesa(
                "Mercado",
                500.0,
                LocalDate.now(),
                CategoriaDespesa.ALIMENTACAO);

        assertEquals(-500.0, despesa.impactoSaldo());
    }
}