import java.util.Scanner;

public class Uni5Exe01 {
    Scanner sc = new Scanner(System.in);

    public Uni5Exe01() {
        informarValores();
    }

    private void informarValores() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Informe o " + i +"º número inteiro:");
            int num = sc.nextInt();
            exibirResultado(num);
        }
    }

    private void exibirResultado(int num) {
        if (num % 2 == 0) {
            System.out.println("Par");
        } else {
            System.out.println("Ímpar");
        }
    }

    public static void main(String[] args) {
        new Uni5Exe01();
    }
}
