package com.caue;

import java.time.LocalDate;

public class Despesa extends Lancamento {
    private CategoriaDespesa categoriaDespesa;

    /**
     * Método constructor da classe Despesa 
     * @param descricao a ser adicionada
     * @param valor a ser adicionado
     * @param data a ser adicionada
     * @param categoriaDespesa a ser adicionada
     */
    public Despesa(String descricao, double valor, LocalDate data, CategoriaDespesa categoriaDespesa) {
        super(descricao, valor, data);
        this.categoriaDespesa = categoriaDespesa;
    }

    /**
     * Método getter para o atributo categoriaDespesa
     * @return categoriaDespesa
     */
    public CategoriaDespesa getCategoriaDespesa() {
        return categoriaDespesa;
    }

    /**
     * Método setter para o atributo categoriaDespesa   
     * @param categoriaDespesa a ser definido
     */
    public void setCategoriaDespesa(CategoriaDespesa categoriaDespesa) {
        this.categoriaDespesa = categoriaDespesa;
    }

    /**
     * Método impactoSaldo retorna o impacto no valor que a despesa tem no saldo, negativo pois a despesa impacta negativamente no saldo
     * @return valor double negativo
     */
    public double impactoSaldo() {
        return -getValor();
    }
}
