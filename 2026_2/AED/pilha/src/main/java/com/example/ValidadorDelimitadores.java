package com.example;

import java.util.Scanner;

public class ValidadorDelimitadores {

    public static boolean validar(String expressao) {
        Pilha<Character> pilha = new PilhaLista<>();

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                pilha.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pilha.estaVazia()) {
                    return false;
                }

                char abre = pilha.pop();
                if (!correspondem(abre, c)) {
                    return false;
                }
            }
        }

        return pilha.estaVazia();
    }

    private static boolean correspondem(char abre, char fecha) {
        return (abre == '(' && fecha == ')')
                || (abre == '[' && fecha == ']')
                || (abre == '{' && fecha == '}');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma expressão aritmética: ");
        String expressao = scanner.nextLine();

        if (validar(expressao)) {
            System.out.println("O uso de delimitadores está correto.");
        } else {
            System.out.println("O uso de delimitadores está incorreto.");
        }

        scanner.close();
    }
}