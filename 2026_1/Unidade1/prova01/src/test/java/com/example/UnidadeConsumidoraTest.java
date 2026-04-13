package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UnidadeConsumidoraTest {
    @Test
    public void testCalcularFatura() {
        UnidadeConsumidora unidade1 = new UnidadeConsumidora(42, Categoria.RESIDENCIAL, 190);
        double resultado1 = 95;
        assertEquals(unidade1.calcularFatura(), resultado1, 0.001);

        UnidadeConsumidora unidade2 = new UnidadeConsumidora(11, Categoria.RESIDENCIAL, 300);
        double resultado2 = 175;
        assertEquals(unidade2.calcularFatura(), resultado2, 0.001);

        UnidadeConsumidora unidade3 = new UnidadeConsumidora(4002, Categoria.COMERCIAL, 700);
        double resultado3 = 525;
        assertEquals(unidade3.calcularFatura(), resultado3, 0.001);

        UnidadeConsumidora unidade4 = new UnidadeConsumidora(89, Categoria.COMERCIAL, 1000);
        double resultado4 = 800;
        assertEquals(unidade4.calcularFatura(), resultado4, 0.001);

        UnidadeConsumidora unidade5 = new UnidadeConsumidora(22, Categoria.INDUSTRIAL, 3000);
        double resultado5 = 2550;
        assertEquals(unidade5.calcularFatura(), resultado5, 0.001);
    }
}
