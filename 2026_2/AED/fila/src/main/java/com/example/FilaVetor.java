package com.example;

public class FilaVetor<T> implements Fila<T> {
    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite) {
        this.limite = limite;
        this.info = new Object[limite];
        this.tamanho = 0;
    }

    public void inserir(T valor) {
        if (tamanho == limite) {
            throw new FilaCheiaException();
        }

        int posicaoInserir;
        posicaoInserir = (inicio + tamanho) % limite;
        info[posicaoInserir] = valor;
        tamanho++;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public T peek() {
        if (estaVazia()) {
            throw new FilaVaziaException();
        }

        return (T) info[inicio];
    }

    public T retirar() {
        T valor = peek();
 
        info[inicio] = null;
        inicio = (inicio + 1) % limite;
        tamanho--;
 
        return valor;

    }

    public void liberar() {
        while (!estaVazia()) {
            retirar();
        }
    }

    @Override 
    public String toString() {
        String resultado = "";
 
        for (int i = 0; i < tamanho; i++) {
            resultado += info[(inicio + i) % limite];
            if (i < tamanho - 1) {
                resultado += ",";
            }
        }
 
        return resultado;

        String retorno = "";

        for (int i = inicio; i < inicio + tamanho; i++) {
            if (i != inicio) {
                retorno == ",";
            }
            
            retorno = retorno + info[i % limite];
        }

        return retorno;

    }

    public int getLimite() {
        return limite;
    }

    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> filaConcatenada = new FilaVetor<>(this.limite + f2.limite);
 
        for (int i = 0; i < this.tamanho; i++) {
            filaConcatenada.inserir((T) this.info[(this.inicio + i) % this.limite]);
        }
 
        for (int i = 0; i < f2.tamanho; i++) {
            filaConcatenada.inserir((T) f2.info[(f2.inicio + i) % f2.limite]);
        }
 
        return filaConcatenada;

}
