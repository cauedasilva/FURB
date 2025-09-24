import java.util.Scanner;

public class Uni4Exe24 {
    Scanner sc = new Scanner(System.in);
    int opcao, num1, num2, num3, maior, meio, menor;

    public Uni4Exe24() {
        informarValor();
        elencarNumeros();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Informe três valores inteiros: ");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();
        System.out.println("Informe a opção desejada: \n1 - escreva os 3 valores em ordem crescente  \n2 - escreva os 3 valores em ordem decrescente \n3 - escreva os 3 valores de forma que o maior valor fique no meio");
        opcao = sc.nextInt();
    }

    private void exibirResultado() {
        switch (opcao) {
            case 1:
                calcularCrescente();
                break;
            case 2:
                calcularDecrescente();
                break;
            case 3:
                calcularMeio();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private void elencarNumeros() {
        if (num1 < num2 && num1 < num3) {
            menor = num1;
            if (num2 < num3) {
                meio = num2;
                maior = num3;
            } else {
                meio = num3;
                maior = num2;
            }
        } else if (num2 < num1 && num2 < num3) {
            menor = num2;
            if (num1 < num3) {
                meio = num1;
                maior = num3;
            } else {
                meio = num3;
                maior = num1;
            }
        } else {
            menor = num3;
            if (num1 < num2) {
                meio = num1;
                maior = num2;
            } else {
                meio = num2;
                maior = num1;
            }
        }
    }

    private void calcularCrescente() {
        System.out.printf("%d %d %d", menor, meio, maior);
    }

    private void calcularDecrescente() {
        System.out.printf("%d %d %d", maior, meio, menor);
    }

    private void calcularMeio() {
        System.out.printf("%d %d %d", meio, maior, menor);
    }


    public static void main(String[] args) {
        new Uni4Exe24();
    }
}
