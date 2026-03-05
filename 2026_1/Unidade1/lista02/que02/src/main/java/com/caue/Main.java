package com.caue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int qtdRep = 2;
        ContaBancaria[] contas = new ContaBancaria[qtdRep];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < qtdRep; i++) {
            contas[i] = new ContaBancaria();
            System.out.println("Informe o número da conta Nº" + i);
            contas[i].setNumero(scanner.next());
            System.out.println("Informe o titular da conta Nº" + i);
            contas[i].setTitular(scanner.next());
        }

        contas[0].depositar(1000);
        contas[0].depositar(700);
        contas[1].depositar(5000);
        contas[1].sacar(3000);
        contas[1].transferir(contas[0], 1800);

        for (int i = 0; i < qtdRep; i++) {
            System.out.println("Titular da conta Nº" + i + ": " + contas[i].getTitular());
            System.out.println("Saldo da conta: " + contas[i].getSaldo());
        }

        scanner.close();
    }
}