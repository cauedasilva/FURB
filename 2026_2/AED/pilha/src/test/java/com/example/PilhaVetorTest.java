package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class PilhaVetorTest {

    @Test
    void caso1() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        assertTrue(pilha.estaVazia());
    }

    @Test
    void caso2() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        assertFalse(pilha.estaVazia());
    }

    @Test
    void caso3() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop().intValue());
        assertEquals(20, pilha.pop().intValue());
        assertEquals(10, pilha.pop().intValue());
        assertTrue(pilha.estaVazia());
    }

    @Test(expected = PilhaCheiaException.class)
    public void caso4() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(3);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
    }


    @Test(expected = PilhaCheiaException.class)
    void caso5() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.pop();
    }

    @Test
    void caso6() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.peek().intValue());
        assertEquals(30, pilha.pop().intValue());
    }

    @Test
    void caso7() {
        PilhaVetor<Integer> pilha = new PilhaVetor<>(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        pilha.liberar();
        assertTrue(pilha.estaVazia());
    }

    @Test
    void caso8() {
        PilhaVetor<Integer> pilha1 = new PilhaVetor<>(5);
        pilha1.push(10);
        pilha1.push(20);
        pilha1.push(30);

        PilhaVetor<Integer> pilha2 = new PilhaVetor<>(2);
        pilha2.push(40);
        pilha2.push(50);

        pilha1.concatenar(pilha2);

        assertEquals("50,40,30,20,10", pilha1.toString());
    }
}