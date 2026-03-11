package com.caue;

public class ContaBancaria {
    private String numero;
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, String numero) {
        setTitular(titular);
        setNumero(numero);
    }

    public void setNumero(String numero) {
        if (numero == null || numero.isEmpty() || numero.isBlank()) {
            throw new IllegalArgumentException("Número inválido");
        }

        this.numero = numero.trim();
    }

    public String getNumero() {
        return this.numero;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.isEmpty() || titular.isBlank()) {
            throw new IllegalArgumentException("Titular inválido");
        }

        this.titular = titular.trim();
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= 0 || this.saldo - valor < 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        this.saldo -= valor;
    }
    
    public void transferir(ContaBancaria contaDestino, double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    } // pertence a uma instância da classe, a um objeto específico; performa a ação a partir de uma instância já declarada
    
    public static void transferir(ContaBancaria origem, ContaBancaria destino, double valor) {
        origem.transferir(destino, valor);
    } // pertence a classe, o método é chamado a partir da classe, e não de uma instância específica; não sabe automaticamente qual são os objetos usados no parâmetro
}

