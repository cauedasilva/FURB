package com.caue;

import java.time.LocalDate;

public class Receita extends Lancamento {
    private CategoriaReceita categoriaReceita;

    public Receita(String descricao, double valor, LocalDate data, CategoriaReceita categoriaReceita) {
        super(descricao, valor, data);
        this.categoriaReceita = categoriaReceita;
    }

    public CategoriaReceita getCategoriaReceita() {
        return categoriaReceita;
    }

    public void setCategoriaReceita(CategoriaReceita categoriaReceita) {
        this.categoriaReceita = categoriaReceita;
    }

    // -------------------------------------------------------------------------
    // Métodos
    // -------------------------------------------------------------------------
    // Receita sempre soma ao saldo (impacto positivo)
    public double impactoSaldo() {
        return getValor();
    }

    @Override
    public double diferencaSaldo() {
        return impactoSaldo();
    }
}
