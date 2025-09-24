import java.util.Scanner;

public class Uni4Exe24 {
    Scanner sc = new Scanner(System.in);
    int opcao, num1, num2, num3;

    public Uni4Exe24() {
        informarValor();
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
                calcularDecrescente();
                break;
            case 2:
                calcularCrescente();
                break;
            case 3:
                calcularMeio();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private void calcularCrescente() {
        if (num1 > num2 && num2 > num3) {
            System.out.printf("%d %d %d", num1, num2, num3);
        } else if (num2 > num3 && num3 > num1) {
            System.out.printf("%d %d %d", num2, num3, num3);
        } else if (num3 > num2 && num2 > num1) {
            System.out.printf("%d %d %d",num3, num2, num1);
        } else if (num2 > num1 && num1 > num3) {
            System.out.printf("%d %d %d",num2, num1, num3);
        } else if (num3 > num1 && num1 > num2) {
            System.out.printf("%d %d %d",num3, num1, num2);
        } else {
            System.out.printf("%d %d %d",num1, num3, num2);
        }
    }

    private void calcularDecrescente() {
        if (num1 > num2 && num2 > num3) {
            System.out.printf("%d %d %d",num3, num2, num1);
        } else if (num2 > num3 && num3 > num1) {
            System.out.printf("%d %d %d",num1, num3, num2);
        } else if (num3 > num2 && num2 > num1) {
            System.out.printf("%d %d %d",num1, num2, num3);
        } else if (num2 > num1 && num1 > num3) {
            System.out.printf("%d %d %d",num3, num1, num2);
        } else if (num3 > num1 && num1 > num2) {
            System.out.printf("%d %d %d",num2, num1, num3);
        } else {
            System.out.printf("%d %d %d",num2, num3, num1);
        }
    }

    private void calcularMeio() {
        if (num1 > num2 && num2 > num3) {
            System.out.printf("%d %d %d",num2, num1, num3);
        } else if (num2 > num3 && num3 > num1) {
            System.out.printf("%d %d %d",num3, num2, num3);
        } else if (num3 > num2 && num2 > num1) {
            System.out.printf("%d %d %d",num2, num3, num1);
        } else if (num2 > num1 && num1 > num3) {
            System.out.printf("%d %d %d",num1, num2, num3);
        } else if (num3 > num1 && num1 > num2) {
            System.out.printf("%d %d %d",num1, num3, num2);
        } else {
            System.out.printf("%d %d %d",num3, num1, num2);
        }
    }


    public static void main(String[] args) {
        new Uni4Exe24();
    }
}
