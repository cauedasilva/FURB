import java.util.Scanner;

public class Uni5Exe12 {
    Scanner sc = new Scanner(System.in);
    int num, k = 1;

    public Uni5Exe12() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        System.out.println("Digite um número: ");
        num = sc.nextInt();
    }

    private void exibirResultado() {
       for (int i = 0; i < num; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }

        System.out.println("o total é: " + num);
    }

    public static void main(String[] args) {
        new Uni5Exe12();
    }
}
