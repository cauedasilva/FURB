package com.caue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[3];

        for (int i = 0; i < 3; i++) {
            Pessoa pessoa = new Pessoa();
            System.out.println("informe o nome: ");
            pessoa.nome = scanner.next();
            System.out.println("Informe o peso: ");
            pessoa.peso = scanner.nextDouble();
            System.out.println("Informe a altura: ");
            pessoa.altura = scanner.nextDouble();
            pessoa.imc = pessoa.calcularImc();
            pessoas[i] = pessoa;
        }

        for (int i = 2; i >= 0; i--) {
            System.out.println("Pessoa Nº" + (i + 1));
            System.out.println("Nome: " + pessoas[i].nome);
            System.out.println("Peso: " + pessoas[i].peso);
            System.out.println("Altura: " + pessoas[i].altura);
            System.out.println("IMC: " + pessoas[i].imc);
        }

        scanner.close();
    }
}