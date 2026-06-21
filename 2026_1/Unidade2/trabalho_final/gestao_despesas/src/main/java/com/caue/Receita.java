package com.caue;

import java.time.LocalDate;

public class Receita extends Lancamento {
    private CategoriaReceita categoriaReceita;

    /**
     * Método constructor da classe Receita
     * @param descricao a ser definida
     * @param valor a ser definido
     * @param data a ser definida
     * @param categoriaReceita a ser definida
     */
    public Receita(String descricao, double valor, LocalDate data, CategoriaReceita categoriaReceita) {
        super(descricao, valor, data);
        setCategoriaReceita(categoriaReceita);
    }

    /**
     * Método getter do atributo categoriaReceita
     * @return objeto de categoriaReceita
     */  
    public CategoriaReceita getCategoriaReceita() {
        return categoriaReceita;
    }

    /**
     * Método setter do atributo categoriaReceita
     * @param categoriaReceita a ser definido
     */
    public void setCategoriaReceita(CategoriaReceita categoriaReceita) {
        this.categoriaReceita = categoriaReceita;
    }

    /**
     * Método impacto saldo, impacto da receita é sempre positivo, retorna-se somente o valor da receita
     * @return double valor da receita
     */
    public double impactoSaldo() {
        return getValor();
    }
}
