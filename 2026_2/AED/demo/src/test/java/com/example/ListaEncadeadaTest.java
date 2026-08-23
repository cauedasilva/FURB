package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaEncadeadaTest {
    private ListaEncadeada<Integer> lista;

    @Before
    public void setUp() {
        lista = new ListaEncadeada<Integer>();
    }

    @Test
    public void listaVazia() {
        assertTrue(lista.estaVazia());
    }

    @Test
    public void listaNaoVazia() {
        lista.inserir(5);
        assertFalse(lista.estaVazia());
    }

    @Test
    public void inclusaoDeUmNumero() {
        lista.inserir(5);

        NoLista<Integer> no = lista.getPrimeiro();
        assertNotNull(no);
        assertEquals(Integer.valueOf(5), no.getInfo());
        assertNull(no.getProximo());
    }

    @Test
    public void inclusaoDeTresNumeros() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);

        NoLista<Integer> no1 = lista.getPrimeiro();
        NoLista<Integer> no2 = no1.getProximo();
        NoLista<Integer> no3 = no2.getProximo();

        assertEquals(Integer.valueOf(15), no1.getInfo());
        assertEquals(Integer.valueOf(10), no2.getInfo());
        assertEquals(Integer.valueOf(5), no3.getInfo());
        assertNull(no3.getProximo());
    }

    @Test
    public void buscaPrimeiraPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> resultado = lista.buscar(20);
        assertNotNull(resultado);
        assertEquals(Integer.valueOf(20), resultado.getInfo());
    }

    @Test
    public void buscaMeioDaLista() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> resultado = lista.buscar(15);
        assertNotNull(resultado);
        assertEquals(Integer.valueOf(15), resultado.getInfo());
    }

    @Test
    public void buscaDadoInexistente() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertNull(lista.buscar(50));
    }

    @Test
    public void exclusaoPrimeiroElemento() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        assertEquals(3, lista.obterComprimento());
        assertEquals("15,10,5", lista.toString());
    }

    @Test
    public void exclusaoElementoDoMeio() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(15);

        assertEquals(3, lista.obterComprimento());
        assertEquals("20,10,5", lista.toString());
    }

    @Test
    public void obterNoPosicaoZero() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(0);
        assertEquals(Integer.valueOf(20), no.getInfo());
    }

    @Test
    public void obterNoUltimaPosicao() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoLista<Integer> no = lista.obterNo(3);
        assertEquals(Integer.valueOf(5), no.getInfo());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void obterNoPosicaoInvalida() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.obterNo(10);
    }

    @Test
    public void caso13_comprimentoListaVazia() {
        assertEquals(0, lista.obterComprimento());
    }

    @Test
    public void comprimentoListaNaoVazia() {
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        assertEquals(4, lista.obterComprimento());
    }
}