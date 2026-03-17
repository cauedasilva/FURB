package com.caue;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("caue", 5000);

        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salário: " + funcionario.getSalario());
        System.out.println("Imposto: " + funcionario.calcularIrpf());
        System.out.println("Faixa IRPF: " + funcionario.identicarFaixaIrpf());
        

    }
}