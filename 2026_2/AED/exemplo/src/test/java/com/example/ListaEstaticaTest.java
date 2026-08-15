package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaEstaticaTest {

    private ListaEstaticaPolimorfica lista;

    @Before
    public void setUp() {
        lista = new ListaEstaticaPolimorfica();
    }

    @Test
    public void caso1() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals("5,10,15,20", lista.toString());
    }

    @Test
    public void caso2() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.getTamanho());
    }

    @Test
    public void caso3() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(2, lista.buscar(15));
    }

    @Test
    public void caso4() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(-1, lista.buscar(30));
    }

    @Test
    public void caso5() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        assertEquals("5,15,20", lista.toString());
        assertEquals(3, lista.getTamanho());
    }

    @Test
    public void caso6() {
        for (int i = 1; i <= 15; i++) {
            lista.inserir(i);
        }

        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15", lista.toString());
        assertEquals(15, lista.getTamanho());
    }

    @Test
    public void caso7() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(20, lista.obterElemento(3));
    }

    @Test
    public void caso8() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        try {
            lista.obterElemento(5);
            fail("Era esperada IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {}
    }

    @Test
    public void caso9() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.liberar();

        assertTrue(lista.estaVazia());
    }

    @Test
    public void caso10() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
 
        lista.inverter();
 
        assertEquals("20,15,10,5", lista.toString());
    }
 
    @Test
    public void caso11() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);
        lista.inserir(25);
 
        lista.inverter();
 
        assertEquals("25,20,15,10,5", lista.toString());
    }

}