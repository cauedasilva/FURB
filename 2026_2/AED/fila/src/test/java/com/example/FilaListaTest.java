package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FilaListaTest {

    @Test
    public void caso1() {
        FilaLista<Integer> fila = new FilaLista<>();

        assertTrue(fila.estaVazia());
    }

    @Test
    public void caso2() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);

        assertFalse(fila.estaVazia());
    }

    @Test
    public void caso3() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(Integer.valueOf(10), fila.retirar());
        assertEquals(Integer.valueOf(20), fila.retirar());
        assertEquals(Integer.valueOf(30), fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test
    public void caso4() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(Integer.valueOf(10), fila.peek());
        assertEquals(Integer.valueOf(10), fila.retirar());
    }

    @Test
    public void caso5() {
        FilaLista<Integer> fila = new FilaLista<>();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        fila.liberar();

        assertTrue(fila.estaVazia());
    }
}