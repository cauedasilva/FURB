import java.util.Scanner;

public class Uni4Exe25 {
    Scanner sc = new Scanner(System.in);
    int num1, num2, opcao;

    public Uni4Exe25() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Informe dois números inteiros maiores que 0:");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        System.out.println("Informe a operação que deseja realizar: \n1 - Soma de dois números. \n2 - Diferença entre dois números. \n3 - Produto entre dois números. \n4 - Divisão entre dois números (o denominador não pode ser zero).");
        opcao = sc.nextInt();
    }

    private void somar() {
        System.out.println(num1 + num2);
    }

    private void subtracao() {
        System.out.println(num1 - num2);
    }

    private void produto() {
        System.out.println(num1 * num2);
    }

    private void divisao() {
        if (num2 != 0) {
            System.out.println(num1 / num2);
        } else {
            System.out.println("O denominador não pode ser zero");
        }
    }

    private void exibirResultado() {
        switch (opcao) {
            case 1:
                somar();
                break;
            case 2:
                subtracao();
                break;
            case 3:
                produto();
                break;
            case 4:
                divisao();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }


    public static void main(String[] args) {
        new Uni4Exe25();
    }
}
