package com.caue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionario[] funcionarios = new Funcionario[5];

        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println("Informe o nome do funcionário Nº" + i + ": ");
            funcionarios[i].setNome(scanner.next());
            System.out.println("Informe o salário do funcionário Nº" + i + ": ");
            funcionarios[i].setSalario(scanner.nextDouble());
        }

        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println("Nome: " + funcionarios[i].getNome());
            System.out.println("Salário: " + funcionarios[i].getSalario());
            System.out.println("Imposto: " + funcionarios[i].calcularIrpf());
        }

        scanner.close();
    }
}