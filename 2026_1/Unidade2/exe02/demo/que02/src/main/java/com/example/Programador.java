package com.example;

import java.util.ArrayList;

public class Programador extends Funcionario {
    private ArrayList<String> linguagens;

    public Programador(String nome, double salarioBase) {
        super(nome, salarioBase);

        this.linguagens = new ArrayList<>();
    }

    public void incluirLinguagem(String linguagem) {
        linguagens.add(linguagem);
    }

    public void removerFuncionario(String linguagem) {
        linguagens.remove(linguagem);
    }

    public ArrayList<String> getLinguagens() {
        return linguagens;
    }

    @Override
    public double calcularSalario() {
        for (String linguagem : linguagens) {
            if (linguagem.equalsIgnoreCase("Java")) {
                return this.salarioBase * 1.20; // 20% de acréscimo
            }
        }
        return this.salarioBase;
    }
}
