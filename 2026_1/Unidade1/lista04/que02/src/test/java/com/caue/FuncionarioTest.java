package com.caue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class FuncionarioTest {
    @Test
    public void testCalcularIrpf() {
        Funcionario funcionario = new Funcionario("Teste", 850);
        double resultado = funcionario.calcularIrpf();
        assertEquals(0, resultado, 0);
        Funcionario funcionario2 = new Funcionario("Teste", 2000);
        double resultado2 = funcionario2.calcularIrpf();
        assertEquals(7.2, resultado2, 0.009);
        Funcionario funcionario3 = new Funcionario("Teste",  2826.66);
        double resultado3 = funcionario3.calcularIrpf();
        assertEquals(69.2, resultado3, 0.009);
        Funcionario funcionario4 = new Funcionario("Teste",  3000);
        double resultado4 = funcionario4.calcularIrpf();
        assertEquals(95.2, resultado4, 0.009);
        Funcionario funcionario5 = new Funcionario("Teste",  4000);
        double resultado5 = funcionario5.calcularIrpf();
        assertEquals(263.87, resultado5, 0.009);
        Funcionario funcionario6 = new Funcionario("Teste",  5000);
        double resultado6 = funcionario6.calcularIrpf();
        assertEquals(505.64, resultado6, 0.009);
    }

    @Test
    public void testIdenticarFaixaIrpf() {
        Funcionario funcionario = new Funcionario("Teste", 850);
        FaixaIrpf resultado = funcionario.identicarFaixaIrpf();
        assertEquals(FaixaIrpf.PRIMEIRA, resultado);
        Funcionario funcionario2 = new Funcionario("Teste", 2000);
        FaixaIrpf resultado2 = funcionario2.identicarFaixaIrpf();
        assertEquals(FaixaIrpf.SEGUNDA, resultado2);
        Funcionario funcionario3 = new Funcionario("Teste",  2826.66);
        FaixaIrpf resultado3 = funcionario3.identicarFaixaIrpf();
        assertEquals(FaixaIrpf.TERCEIRA, resultado3);
        Funcionario funcionario4 = new Funcionario("Teste",  3000);
        FaixaIrpf resultado4 = funcionario4.identicarFaixaIrpf();
        assertEquals(FaixaIrpf.TERCEIRA, resultado4);
        Funcionario funcionario5 = new Funcionario("Teste",  4000);
        FaixaIrpf resultado5 = funcionario5.identicarFaixaIrpf();
        assertEquals(FaixaIrpf.QUARTA, resultado5);
        Funcionario funcionario6 = new Funcionario("Teste",  5000);
        FaixaIrpf resultado6 = funcionario6.identicarFaixaIrpf();
        assertEquals(FaixaIrpf.QUINTA, resultado6);
    }

    @Test
    public void testSetSalario() {
       Funcionario funcionario = new Funcionario("Teste", 100);
       String mensagemEsperada = "Salário deve ser maior que Zero";
       Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        funcionario.setSalario(-100);
       });

       assertEquals(mensagemEsperada, exception.getMessage());
    }
}
