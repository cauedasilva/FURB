package com.example;

public class MapaDispersao<T> {

    private ListaEncadeada<NoMapa<T>>[] info;

    @SuppressWarnings("unchecked")
    public MapaDispersao(int tamanho) {
        if (tamanho <= 0) {
            throw new IllegalArgumentException("O tamanho do mapa deve ser positivo");
        }

        info = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) {
            info[i] = new ListaEncadeada<NoMapa<T>>();
        }
    }

    private int calcularHash(int chave) {
        return chave % info.length;
    }

    public void inserir(int chave, T dado) {
        int indice = calcularHash(chave);
        NoLista<NoMapa<T>> existente = info[indice].buscar(new NoMapa<T>(chave, null));
        if (existente != null) {
            existente.getInfo().setInfo(dado);
        } else {
            info[indice].inserir(new NoMapa<T>(chave, dado));
        }
    }

    public void remover(int chave) {
        int indice = calcularHash(chave);
        info[indice].retirar(new NoMapa<T>(chave, null));
    }

    public T buscar(int chave) {
        int indice = calcularHash(chave);
        NoLista<NoMapa<T>> no = info[indice].buscar(new NoMapa<T>(chave, null));
        if (no == null) {
            return null;
        }
        return no.getInfo().getInfo();
    }
}