package com.caue;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Teste");
        funcionario.setSalario(3000);
        System.out.println("Imposto final: " + funcionario.calcularIrpf());
    }
}