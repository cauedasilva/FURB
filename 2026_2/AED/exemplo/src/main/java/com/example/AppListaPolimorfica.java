package com.example;

/**
 * Hello world!
 *
 */
public class AppListaPolimorfica 
{
    public static void main( String[] args )
    {
        ListaEstaticaPolimorfica<Aluno> alunos = new ListaEstaticaPolimorfica();

        Aluno a1 = new Aluno(1100, "Cauê");
        alunos.inserir(new Aluno(8000, "Ana")); // só irá aceitar objetos do tipo aluno

    }
}
