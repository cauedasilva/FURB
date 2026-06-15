package com.caue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContaEspecialTest {
    @Test
    public void testSacar() {
        Cliente cliente = new Cliente("teste", "teste");
        ContaEspecial contaEspecial = new ContaEspecial("1", 0, cliente, 100);
        contaEspecial.depositar(20);
        contaEspecial.sacar(50);
        assertEquals(contaEspecial.getSaldo(), -30, 0.009);

        Cliente cliente2 = new Cliente("teste", "teste");
        ContaEspecial contaEspecial2 = new ContaEspecial("1", 0, cliente2, 100);
        contaEspecial2.depositar(20);
        contaEspecial2.sacar(120);
        assertEquals(contaEspecial2.getSaldo(), -100, 0.009);

        Cliente cliente3 = new Cliente("teste", "teste");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ContaEspecial contaEspecial3 = new ContaEspecial("1", 0, cliente3, 100);
            contaEspecial3.depositar(20);
            contaEspecial3.sacar(120.01);
        });
        assertEquals("valor inválido", exception.getMessage());
    }
}
