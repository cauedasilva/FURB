package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListaDuplaTest {

    @Test
    void teste1() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> p = lista.getPrimeiro();
        assertEquals(Integer.valueOf(20), p.getInfo());
        p = p.getProximo();
        assertEquals(Integer.valueOf(15), p.getInfo());
        p = p.getProximo();
        assertEquals(Integer.valueOf(10), p.getInfo());
        p = p.getProximo();
        assertEquals(Integer.valueOf(5), p.getInfo());
        assertNull(p.getProximo());

        NoListaDupla<Integer> ultimo = p;
        assertEquals(Integer.valueOf(5), ultimo.getInfo());
        ultimo = ultimo.getAnterior();
        assertEquals(Integer.valueOf(10), ultimo.getInfo());
        ultimo = ultimo.getAnterior();
        assertEquals(Integer.valueOf(15), ultimo.getInfo());
        ultimo = ultimo.getAnterior();
        assertEquals(Integer.valueOf(20), ultimo.getInfo());
        assertNull(ultimo.getAnterior());
    }

    @Test
    void teste2() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> resultado = lista.buscar(20);

        assertNotNull(resultado);
        assertEquals(Integer.valueOf(20), resultado.getInfo());
    }

    @Test
    void teste3() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> resultado = lista.buscar(10);

        assertNotNull(resultado);
        assertEquals(Integer.valueOf(10), resultado.getInfo());
    }

    @Test
    void teste4() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(20);

        NoListaDupla<Integer> p = lista.getPrimeiro();
        assertEquals(Integer.valueOf(15), p.getInfo());
        p = p.getProximo();
        assertEquals(Integer.valueOf(10), p.getInfo());
        p = p.getProximo();
        assertEquals(Integer.valueOf(5), p.getInfo());
        assertNull(p.getProximo());

        NoListaDupla<Integer> ultimo = p;
        assertEquals(Integer.valueOf(5), ultimo.getInfo());
        ultimo = ultimo.getAnterior();
        assertEquals(Integer.valueOf(10), ultimo.getInfo());
        ultimo = ultimo.getAnterior();
        assertEquals(Integer.valueOf(15), ultimo.getInfo());
        assertNull(ultimo.getAnterior());
    }

    @Test
    void teste5() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(10);

        NoListaDupla<Integer> p = lista.getPrimeiro();
        assertEquals(Integer.valueOf(20), p.getInfo());
        p = p.getProximo();
        assertEquals(Integer.valueOf(15), p.getInfo());
        p = p.getProximo();
        assertEquals(Integer.valueOf(5), p.getInfo());
        assertNull(p.getProximo());

        NoListaDupla<Integer> ultimo = p;
        assertEquals(Integer.valueOf(5), ultimo.getInfo());
        ultimo = ultimo.getAnterior();
        assertEquals(Integer.valueOf(15), ultimo.getInfo());
        ultimo = ultimo.getAnterior();
        assertEquals(Integer.valueOf(20), ultimo.getInfo());
        assertNull(ultimo.getAnterior());
    }

    @Test
    void teste6() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        lista.retirar(5);

        NoListaDupla<Integer> p = lista.getPrimeiro();
        assertEquals(Integer.valueOf(20), p.getInfo());
        p = p.getProximo();
        assertEquals(Integer.valueOf(15), p.getInfo());
        p = p.getProximo();
        assertEquals(Integer.valueOf(10), p.getInfo());
        assertNull(p.getProximo());

        NoListaDupla<Integer> ultimo = p;
        assertEquals(Integer.valueOf(10), ultimo.getInfo());
        ultimo = ultimo.getAnterior();
        assertEquals(Integer.valueOf(15), ultimo.getInfo());
        ultimo = ultimo.getAnterior();
        assertEquals(Integer.valueOf(20), ultimo.getInfo());
        assertNull(ultimo.getAnterior());
    }

    @Test
    void teste7() {
        ListaDupla<Integer> lista = new ListaDupla<>();
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        NoListaDupla<Integer> no5 = lista.buscar(5);
        NoListaDupla<Integer> no10 = lista.buscar(10);
        NoListaDupla<Integer> no15 = lista.buscar(15);
        NoListaDupla<Integer> no20 = lista.buscar(20);

        lista.liberar();

        assertNull(no5.getProximo());
        assertNull(no5.getAnterior());
        assertNull(no10.getProximo());
        assertNull(no10.getAnterior());
        assertNull(no15.getProximo());
        assertNull(no15.getAnterior());
        assertNull(no20.getProximo());
        assertNull(no20.getAnterior());
    }
}