import java.util.Scanner;

public class Uni4Exe09 {
    Scanner sc = new Scanner(System.in);
    int num1, num2;

    public Uni4Exe09() {
        informarValores();
        exibirResultado();
    }

    private void exibirResultado() {
        if (num1 % num2 == 0) {
            System.out.println("Os valores são múltiplos.");
        } else {
            System.out.println("Os valores não são múltiplos.");
        }
    }

    private void informarValores() {
        System.out.println("Escreva o primeiro número inteiro: ");
        num1 = sc.nextInt();
        System.out.println("Escreva o segundo número inteiro: ");
        num2 = sc.nextInt();
    }

    public static void main(String[] args) {
        new Uni4Exe09();
    }
}
