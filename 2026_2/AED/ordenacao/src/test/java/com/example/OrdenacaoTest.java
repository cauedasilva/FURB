package com.example;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;


public class OrdenacaoTest {

    private Integer[] criarVetor() {
        return new Integer[] { 70, 2, 88, 15, 90, 30 };
    }

    private final Integer[] esperado = { 2, 15, 30, 70, 88, 90 };

    @Test
    public void caso1() {
        OrdenacaoBolha<Integer> ordenacao = new OrdenacaoBolha<>();
        ordenacao.setInfo(criarVetor());
        ordenacao.ordenar();
        assertArrayEquals(esperado, ordenacao.getInfo());
    }

    @Test
    public void caso2() {
        OrdenacaoBolhaOtimizada<Integer> ordenacao = new OrdenacaoBolhaOtimizada<>();
        ordenacao.setInfo(criarVetor());
        ordenacao.ordenar();
        assertArrayEquals(esperado, ordenacao.getInfo());
    }

    @Test
    public void caso3() {
        OrdenacaoQuickSort<Integer> ordenacao = new OrdenacaoQuickSort<>();
        ordenacao.setInfo(criarVetor());
        ordenacao.ordenar();
        assertArrayEquals(esperado, ordenacao.getInfo());
    }

    @Test
    public void caso4() {
        OrdenacaoMergeSort<Integer> ordenacao = new OrdenacaoMergeSort<>();
        ordenacao.setInfo(criarVetor());
        ordenacao.ordenar();
        assertArrayEquals(esperado, ordenacao.getInfo());
    }
}
