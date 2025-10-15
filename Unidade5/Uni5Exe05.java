import java.util.Scanner;

public class Uni5Exe05 {
    Scanner sc = new Scanner(System.in);
    double num, x;

    public Uni5Exe05() {
        inserirValor();
    }

    private void inserirValor() {
        System.out.println("Escreva um número inteiro maior que 2: ");
        num = sc.nextInt();
        if (num <= 2) {
            System.out.println("Digite novamente");
        } else {
            exibirResultado(num);
        }
    }

    private void exibirResultado(double num) {
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                x = i * (i + 1);
                System.out.print(x + ", ");
            } else {
                x = 2 * i + 1;
                System.out.print(x + ", ");
            }
        }    
    }

    public static void main(String[] args) {
        new Uni5Exe05();
    }
}
