package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FilaVetorTest {

    @Test
    public void caso1() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);

        assertTrue(fila.estaVazia());
    }

    @Test
    public void caso2() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);

        assertFalse(fila.estaVazia());
    }

    @Test
    public void caso3() {
        FilaVetor<Integer> fila = new FilaVetor<>(10);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(Integer.valueOf(10), fila.retirar());
        assertEquals(Integer.valueOf(20), fila.retirar());
        assertEquals(Integer.valueOf(30), fila.retirar());
        assertTrue(fila.estaVazia());
    }

    @Test(expected = FilaCheiaException.class)
    public void caso4() {
        FilaVetor<Integer> fila = new FilaVetor<>(3);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);
    }

    @Test(expected = FilaVaziaException.class)
    public void caso5() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.retirar();
    }

    @Test
    public void caso6() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        assertEquals(Integer.valueOf(10), fila.peek());
        assertEquals(Integer.valueOf(10), fila.retirar());
    }

    @Test
    public void caso7() {
        FilaVetor<Integer> fila = new FilaVetor<>(5);
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        fila.liberar();

        assertTrue(fila.estaVazia());
    }

    @Test
    public void caso8() {
        FilaVetor<Integer> f1 = new FilaVetor<>(5);
        f1.inserir(10);
        f1.inserir(20);
        f1.inserir(30);

        FilaVetor<Integer> f2 = new FilaVetor<>(3);
        f2.inserir(40);
        f2.inserir(50);

        FilaVetor<Integer> f3 = f1.criarFilaConcatenada(f2);

        assertEquals("10,20,30,40,50", f3.toString());

        assertEquals("10,20,30", f1.toString());
        assertEquals("40,50", f2.toString());

        assertEquals(8, f3.getLimite());
    }
}