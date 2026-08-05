package com.example;

public class ListaEstatica { // Recriação de um ArrayList
    private int[] info; // variável de referência
    private int tamanho;

    public ListaEstatica() {
        info = new int[10]; // há dois objetos no heap no momento do instanciamento da classe, o objeto ListaEstatica e o vetor
        tamanho = 0;
    }

    public void inserir(int valor) {
        info[tamanho] = valor;
        tamanho++; // incrementar o tamanho da lista, para que o próximo item inserido seja no byte imediatamente após o anterior
        // se o tamanho da lista for esgotado será criado um novo vetor com 10 posições a mais que o anterior, a geração de posições não será incremental
        // porém essa recriação é trabalhosa, e será aplicado neste algoritmo simples
        // o ArrayList aumenta em 50% o tamanho do vetor no redimensionamento
    }
}
