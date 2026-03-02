package com.caue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Pessoa pessoa = new Pessoa();
        pessoa.altura = 1.75;
        pessoa.peso = 78;

        System.out.println("O IMC é: " + pessoa.calcularImc());
    }
}
