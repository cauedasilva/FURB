package com.caue;

import java.time.LocalDate;

public class Despesa extends Lancamento {
    private CategoriaDespesa categoriaDespesa;

    public Despesa(String descricao, double valor, LocalDate data, CategoriaDespesa categoriaDespesa) {
        super(descricao, valor, data);
        this.categoriaDespesa = categoriaDespesa;
    }

    public CategoriaDespesa getCategoriaDespesa() {
        return categoriaDespesa;
    }

    public void setCategoriaDespesa(CategoriaDespesa categoriaDespesa) {
        this.categoriaDespesa = categoriaDespesa;
    }
    
    // Despesa sempre subtrai do saldo (impacto negativo)
    public double impactoSaldo() {
        return -getValor();
    }

    @Override
    public double diferencaSaldo() {
        return impactoSaldo();
    }
}
