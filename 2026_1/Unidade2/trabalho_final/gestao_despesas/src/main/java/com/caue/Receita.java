package com.caue;

import java.time.LocalDate;

public class Receita extends Lancamento {

    private CategoriaReceita categoriaReceita;

    public Receita(String descricao, double valor, LocalDate data, CategoriaReceita categoriaReceita) {
        super(descricao, valor, data);
        setCategoriaReceita(categoriaReceita);
    }

    public CategoriaReceita getCategoriaReceita() {
        return this.categoriaReceita;
    }

    public void setCategoriaReceita(CategoriaReceita categoriaReceita) {
        if (categoriaReceita == null) {
            throw new IllegalArgumentException("");
        }

        this.categoriaReceita = categoriaReceita;
    }

    @Override
    public double diferencaSaldo() {
        return 0;
    }

    public double impactoSaldo() {
        return 0;
    }
}
