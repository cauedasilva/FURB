package com.caue;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class LancamentoTest {

    @Test
    public void testCompareToDataAnterior() {
        Lancamento anterior = new Receita("Salário", 1000.0, LocalDate.of(2026, 1, 10), CategoriaReceita.SALARIO);
        Lancamento posterior = new Receita("Salário", 1000.0, LocalDate.of(2026, 2, 10), CategoriaReceita.SALARIO);

        assertTrue(anterior.compareTo(posterior) < 0, "Lançamento com data anterior deve retornar valor negativo na comparação");
    }

    @Test
    public void testCompareToDataPosterior() {
        Lancamento anterior = new Receita("Salário", 1000.0, LocalDate.of(2026, 1, 10), CategoriaReceita.SALARIO);
        Lancamento posterior = new Receita("Salário", 1000.0, LocalDate.of(2026, 2, 10), CategoriaReceita.SALARIO);

        assertTrue(posterior.compareTo(anterior) > 0, "Lançamento com data posterior deve retornar valor positivo na comparação");
    }

    @Test
    public void testCompareToDataIgual() {
        LocalDate mesmaData = LocalDate.of(2026, 5, 1);
        Lancamento l1 = new Receita("Salário", 1000.0, mesmaData, CategoriaReceita.SALARIO);
        Lancamento l2 = new Despesa("Aluguel", 800.0, mesmaData, CategoriaDespesa.RESIDENCIA);

        assertEquals(0, l1.compareTo(l2), "Lançamentos com a mesma data devem retornar 0 na comparação");
    }
}