package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Integer i = Integer.valueOf(10);

        ListaEstaticaPolimorfica<Integer> numeros = new ListaEstaticaPolimorfica<>();
        numeros.inserir(Integer.valueOf(i));
    }
}
