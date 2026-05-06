package com.example;

public class Main {
    public static void main(String[] args) {
        Vendedor v1 = new Vendedor("Luiz", 1000, 10);
        Vendedor v2 = new Vendedor("Paula", 1200, 7);

        Venda s1 = new Venda(200);
        Venda s2 = new Venda(100);

        Venda p1 = new Venda(500);
        Venda p2 = new Venda(350);
        Venda p3 = new Venda(280);

        v1.incluirVenda(s1);
        v1.incluirVenda(s2);

        v2.incluirVenda(p1);
        v2.incluirVenda(p2);
        v2.incluirVenda(p3);

        Programador d1 = new Programador("Julio", 1000);
        Programador d2 = new Programador("Ana", 1000);
        Programador d3 = new Programador("Anderson", 1200);

        d1.incluirLinguagem("C");
        d1.incluirLinguagem("Java");

        d2.incluirLinguagem("Java");
        d2.incluirLinguagem("C#");

        d3.incluirLinguagem("Python");

        Funcionario f1 = new Funcionario("José", 1000);
        Funcionario f2 = new Funcionario("Maria", 1400);

        Empresa empresa = new Empresa("teste");
        empresa.incluirFuncionario(v1);
        empresa.incluirFuncionario(v2);
        empresa.incluirFuncionario(d1);
        empresa.incluirFuncionario(d2);
        empresa.incluirFuncionario(d3);
        empresa.incluirFuncionario(f1);
        empresa.incluirFuncionario(f2);

        System.out.println(empresa.calcularCustosSalarios());
        for (Funcionario f : empresa.getFuncionarios()) {
            System.out.println(f.getNome() + " : " + f.calcularSalario());
            if (f instanceof Programador) {
                Programador p = (Programador) f; 
                
                System.out.println("Linguagens: " + p.getLinguagens());
            } 
            else if (f instanceof Vendedor) {
                Vendedor v = (Vendedor) f;
                System.out.println("Comissão: " + v.getPercentualComissao());
            }
        }
    }
}