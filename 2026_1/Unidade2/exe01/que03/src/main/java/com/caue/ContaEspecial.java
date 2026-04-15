package com.caue;

public class ContaEspecial extends ContaBancaria {
    private double limiteCredito;

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public ContaEspecial(String numero, double saldo, Cliente titular, double limiteCredito) {
        super(numero, saldo, titular);
        setLimiteCredito(limiteCredito);
    }

    public void sacar(double valor) {
        if (valor > (getLimiteCredito() + getSaldo())) {
            throw new IllegalArgumentException("valor inválido");
        }

        Movimento movimento = new Movimento(valor, TipoMovimento.DEBITO);
        incluirMovimento(movimento);
        setSaldo(getSaldo() - valor);
    }

}
