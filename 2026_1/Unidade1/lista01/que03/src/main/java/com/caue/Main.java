package com.caue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        for (int i = 0; i < 3; i++) {
            System.out.println("Informe o peso: ");
            pessoa.peso = scanner.nextDouble();
            System.out.println("Informe a altura: ");
            pessoa.altura = scanner.nextDouble();

            System.out.println("O IMC é: " + pessoa.calcularImc());
        }

        scanner.close();
    }
}