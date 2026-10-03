package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ArvoreTest {

    private Arvore<Integer> arvore;

    @Before
    public void iniciar() {
        NoArvore<Integer> n1 = new NoArvore<>(1);
        NoArvore<Integer> n2 = new NoArvore<>(2);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        NoArvore<Integer> n4 = new NoArvore<>(4);
        NoArvore<Integer> n5 = new NoArvore<>(5);
        NoArvore<Integer> n6 = new NoArvore<>(6);
        NoArvore<Integer> n7 = new NoArvore<>(7);
        NoArvore<Integer> n8 = new NoArvore<>(8);
        NoArvore<Integer> n9 = new NoArvore<>(9);
        NoArvore<Integer> n10 = new NoArvore<>(10);

        n2.inserirFilho(n7);
        n2.inserirFilho(n6);
        n2.inserirFilho(n5);

        n3.inserirFilho(n8);

        n4.inserirFilho(n10);
        n4.inserirFilho(n9);

        n1.inserirFilho(n4);
        n1.inserirFilho(n3);
        n1.inserirFilho(n2);

        arvore = new Arvore<>();
        arvore.setRaiz(n1);
    }

    @Test
    public void test1() {
        assertEquals("<1<2<5><6><7>><3<8>><4<9><10>>>", arvore.toString());
    }

    @Test
    public void test2() {
        assertTrue(arvore.pertence(7));
    }

    @Test
    public void test3() {
        assertFalse(arvore.pertence(55));
    }

    @Test
    public void test4() {
        assertEquals(10, arvore.contarNos());
    }
}