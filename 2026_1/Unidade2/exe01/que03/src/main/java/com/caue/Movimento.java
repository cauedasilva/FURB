package com.caue;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movimento {
    private double valor;
    private TipoMovimento tipoMovimento;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return LocalDate.now();
    }

    public LocalTime getHora() {
        return LocalTime.now();
    }

    public TipoMovimento getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimento tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public Movimento(double valor, TipoMovimento tipoMovimento) {
        setValor(valor);
        setTipoMovimento(tipoMovimento);
    }

}
