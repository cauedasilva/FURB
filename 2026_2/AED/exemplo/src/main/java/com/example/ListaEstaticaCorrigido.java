package com.example;

public class ListaEstatica { // Recriação de um ArrayList
    private int[] info; // variável de referência
    private int tamanho;

    public ListaEstatica() {
        info = new int[10]; // há dois objetos no heap no momento do instanciamento da classe, o objeto ListaEstatica e o vetor
        tamanho = 0;
    }

    public void inserir(int valor) {
        if (tamanho == info.length)     {
            redimensionar();
        }

        info[tamanho] = valor;
        tamanho++;
    }

    private void redimensionar() { // como podemos minimizar a chamada desse método? 
        int[] novo = new int[info.length + 10]; // + 100000, reduz o número de chamadas, porém há muito desperdício de memória, não é uma boa solução
        //

        for (int i = 0; i < tamanho; i++) {
            novo[i] = info[i];
        }

        info = novo;
    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(info[i]);
        }
    }

    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (info[i] == valor) {
                return i;
            }
        }

        return -1;
    }

    public void retirar(int valor) {
        int pos = buscar(valor);

        if (pos == -1) {
            return;
        }

        for (int i = pos; i < tamanho - 1; i++) {
            info[i] = info[i+1];
        }

        // não faz sentido realizar um comando para atribuir a pos = 0
        // isso não irá economizar memória e irá somente consumir mais processamento

        tamanho--;
    }

    public void liberar() {
        info = new int[10]; // há dois objetos no heap no momento do instanciamento da classe, o objeto ListaEstatica e o vetor
        tamanho = 0;
    }

    public int obterElemento(int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException();
        }

        return info[posicao];
    }

    public boolean estaVazia() {
        return tamanho==0;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        String resultado = "";

        for (int i = 0; i < tamanho; i++) {
            if (i > 0) {
                resultado += ",";
            }
            resultado += info[i];
        }

        return resultado;
    }
}
