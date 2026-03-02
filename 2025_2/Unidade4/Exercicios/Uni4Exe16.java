import java.util.Scanner;

public class Uni4Exe16 {
    Scanner sc = new Scanner(System.in);
    int h1, h2, m1, m2;

    public Uni4Exe16() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Escreva a idade dos dois homens: ");
        h1 = sc.nextInt();
        h2 = sc.nextInt();
        System.out.println("Escreva a idade das duas mulheres: ");
        m1 = sc.nextInt();
        m2 = sc.nextInt();
    }

    private void exibirResultado() {
        if (h1 > h2 && m1 > m2) {
            System.out.println("Soma: " + (h1 + m2));
            System.out.println("Produto: " + h2 * m1);
        } else if (h2 > h1 && m1 > m2) {
            System.out.println("Soma: " + (h2 + m2));
            System.out.println("Produto: " + h1 * m1);
        } else if (h1 > h2 && m2 > m1) {
            System.out.println("Soma: " + (h1 + m1));
            System.out.println("Produto: " + h2 * m2);
        } else {
            System.out.println("Soma: " + (h2 + m2));
            System.out.println("Produto: " + h1 * m1);
        }
    }


    public static void main(String[] args) {
        new Uni4Exe16();
    }
}
