package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class PilhaListaTest {

    @Test
    void caso1() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        assertTrue(pilha.estaVazia());
    }

    @Test
    void caso2() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        assertFalse(pilha.estaVazia());
    }

    @Test
    void caso3() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop().intValue());
        assertEquals(20, pilha.pop().intValue());
        assertEquals(10, pilha.pop().intValue());
        assertTrue(pilha.estaVazia());
    }

    @Test
    void caso4() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.peek().intValue());
        assertEquals(30, pilha.pop().intValue());
    }

    @Test
    void caso5() {
        PilhaLista<Integer> pilha = new PilhaLista<>();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();
        assertTrue(pilha.estaVazia());
    }
}