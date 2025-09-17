import java.util.Scanner;

public class Uni4Exe03 {
    Scanner sc = new Scanner(System.in);
    int num1, num2;

    public Uni4Exe03() {
        informarValores();
        exibirResultado();
    }

    private void informarValores() {
        System.out.println("Informe o primeiro número inteiro: ");
        num1 = sc.nextInt();
        System.out.println("Informe o segundo número inteiro");
        num2 = sc.nextInt();
    }

    private void exibirResultado() {
        if (num1 > num2) {
            System.out.printf("O valor %d é maior do que o valor %d", num1, num2);
        } else if (num1 == num2) {
            System.out.println("Os valores são iguais");
        } else {
            System.out.printf("O valor %d é maior do que o valor %d", num2, num1);
        }
    }

    public static void main(String[] args) {
        new Uni4Exe03();
    }
}
