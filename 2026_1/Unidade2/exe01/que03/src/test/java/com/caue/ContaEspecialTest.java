package com.caue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContaEspecialTest {
    @Test
    public void testSacar() {
        Cliente cliente = new Cliente("teste", "teste");
        ContaEspecial contaEspecial = new ContaEspecial("1", 0, cliente, 100);
        contaEspecial.depositar(1000);
        contaEspecial.sacar(250);
        assertEquals(contaEspecial.getMovimento().get(0).getValor(), 1000);
        assertEquals(contaEspecial.getMovimento().get(0).getTipoMovimento(), TipoMovimento.CREDITO);
        assertEquals(contaEspecial.getMovimento().get(1).getValor(), 250);
        assertEquals(contaEspecial.getMovimento().get(1).getTipoMovimento(), TipoMovimento.DEBITO);
    }
}
