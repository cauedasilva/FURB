import java.util.Scanner;

public class Uni5Exe05 {
    Scanner sc = new Scanner(System.in);
    int num, x = 4;

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
                x = x + 2;
            } else {
                x = (x - 2) * 2;
            }
            System.out.print(x + " ");
        }    
    }

    public static void main(String[] args) {
        new Uni5Exe05();
    }
}
