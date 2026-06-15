package com.example;

public class Municipio {
    public int getCodIbge() {
        return codIbge;
    }
    public void setCodIbge(int codIbge) {
        this.codIbge = codIbge;
    }
    private int codIbge;
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    private String uf;
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
    private int populacao;
    public int getPopulacao() {
        return populacao;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public Municipio(int codigo, String nome, String uf, int populacao) {
        setCodIbge(codigo);
        setNome(nome);
        setPopulacao(populacao);
        setUf(uf);
    }
}
