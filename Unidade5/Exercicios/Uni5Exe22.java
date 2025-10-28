import java.util.Scanner;

public class Uni5Exe22 {
    Scanner sc = new Scanner(System.in);
    double salario = 2000, aumento = 0.015;
    int ano = 1995;

    public Uni5Exe22() {
        exibirResultado();
    }

    private void exibirResultado() {
        while (ano < 2025) {
            salario += aumento * salario;
            aumento = aumento * 2;
            ano++;
        }

        System.out.println("Salário atual é: R$" + salario);
    }

    public static void main(String[] args) {
        new Uni5Exe22();
    }
}