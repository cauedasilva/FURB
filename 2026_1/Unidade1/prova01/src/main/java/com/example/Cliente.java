package com.example;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private ArrayList<UnidadeConsumidora> unidades = new ArrayList<>(); 

    /**
     * Método getter para o atributo nome 
     */

    public String getNome() {
        return nome;
    }

    /**
     * Método setter para o atributo nome 
     * @param nome nome a ser utilizado
     */

    public void setNome(String nome) {
        if (nome == null || nome.trim().isBlank()) {
            throw new IllegalArgumentException("nome invalido");
        }
        this.nome = nome;
    }

    /*
    * Método constructor da classe Cliente
    */

    public Cliente(String nome) {
        setNome(nome);
    }

    /**
     * Método calcularTotalFatura calcular o valor total de todas as unidades consumidoras do cliente
     * @return um valor double somando o valor da fatura de todas as unidades consumidoras do cliente
     */

    public double calcularTotalFatura() {
        double total = 0;

        for (int i = 0; i < unidades.size(); i++) {
            total += unidades.get(i).calcularFatura();
        }

        return total;
    }

    /**
     * Adiciona uma unidade consumidora ao ArrayList
     * @param unidade unidade a ser adicionada
     */

    public void adicionarUnidade(UnidadeConsumidora unidade) {
        if (unidade == null) {
            throw new IllegalArgumentException("unidade invalido");
        }
    }
    
    /**
     * Remove uma unidade consumidora do ArrayList
     * @param unidade unidade a ser removida
     */

    public void removerUnidade(UnidadeConsumidora unidade) {
        if (unidade == null) {
            throw new IllegalArgumentException("unidade invalido");
        }
    }

    /**
     * Método getter do ArrayList UnidadeConsumidora
     * @return o ArrayList de todas as unidades consumidoras do cliente
     */

    public ArrayList<UnidadeConsumidora> getUnidades() {
        return unidades;
    }

    /**
     * Método imprimirFatura imprime no terminal todas as unidades consumidoras do cliente
     */

    public void imprimirFatura() {
        for (UnidadeConsumidora unidade : unidades) {
            System.out.println("Identificador " + unidade.getIdentificador() + " Categoria " + unidade.getCategoria() + " Valor da Fatura " + unidade.calcularFatura());
        }
    }
}
