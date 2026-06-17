package com.caue;

import java.time.LocalDate;

public class Receita extends Lancamento {

    private CategoriaReceita categoriaReceita;

    public Receita(String descricao, double valor, LocalDate data, CategoriaReceita categoriaReceita) {
        super(descricao, valor, data);
    }

    public CategoriaReceita getCategoriaReceita() {
        return null;
    }

    public void setCategoriaReceita(CategoriaReceita categoriaReceita) {
    }

    @Override
    public double diferencaSaldo() {
        return 0;
    }

    public double impactoSaldo() {
        return 0;
    }
}
