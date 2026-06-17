package com.caue;

import java.time.LocalDate;

public class Despesa extends Lancamento {

    private CategoriaDespesa categoriaDespesa;

    public Despesa(String descricao, double valor, LocalDate data, CategoriaDespesa categoriaDespesa) {
        super(descricao, valor, data);
    }

    public CategoriaDespesa getCategoriaDespesa() {
        return null;
    }

    public void setCategoriaDespesa(CategoriaDespesa categoriaDespesa) {
    }

    @Override
    public double diferencaSaldo() {
        return 0;
    }

    public double impactoSaldo() {
        return 0;
    }
}
