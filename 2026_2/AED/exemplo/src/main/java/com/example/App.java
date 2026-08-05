package com.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);

        for (int i=0; i<numeros.size(); i++) {
            System.out.println(numeros.get(i));
        }

        ListaEstatica lista = new ListaEstatica();
        lista.inserir(10);
        lista.inserir(20);

        for (int i=0; i<lista.getTamanho(); i++) {
            System.out.println(lista.obterElemento(i));
        }

    }
}
