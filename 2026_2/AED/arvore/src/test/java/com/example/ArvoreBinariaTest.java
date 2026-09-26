package com.example;

import org.junit.Test;
import static org.junit.Assert.*;


public class ArvoreBinariaTest {

    private ArvoreBinaria<Integer> criarArvore() {
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no4);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no5, no6);

        NoArvoreBinaria<Integer> raiz = new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(raiz);
        return arvore;
    }

    @Test
    public void testCaso1() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        assertTrue(arvore.estaVazia());
    }

    @Test
    public void testCaso2() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.setRaiz(new NoArvoreBinaria<>(5));
        assertFalse(arvore.estaVazia());
    }

    @Test
    public void testCaso3() {
        ArvoreBinaria<Integer> arvore = criarArvore();
        String esperado = "<1<2<><4<><>>><3<5<><>><6<><>>>>";
        assertEquals(esperado, arvore.toString());
    }

    @Test
    public void testCaso4() {
        ArvoreBinaria<Integer> arvore = criarArvore();
        assertTrue(arvore.pertence(1));
    }

    @Test
    public void testCaso5() {
        ArvoreBinaria<Integer> arvore = criarArvore();
        assertTrue(arvore.pertence(3));
    }

    @Test
    public void testCaso6() {
        ArvoreBinaria<Integer> arvore = criarArvore();
        assertTrue(arvore.pertence(6));
    }

    @Test
    public void testCaso7() {
        ArvoreBinaria<Integer> arvore = criarArvore();
        assertFalse(arvore.pertence(10));
    }

    @Test
    public void testCaso8() {
        ArvoreBinaria<Integer> arvore = criarArvore();
        assertEquals(6, arvore.contarNos());
    }
}