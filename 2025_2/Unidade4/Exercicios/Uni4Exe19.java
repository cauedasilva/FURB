import java.util.Scanner;

public class Uni4Exe19 {
    Scanner sc = new Scanner(System.in);
    int x, y;

    public Uni4Exe19() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Informe o ponto X: ");
        x = sc.nextInt();
        System.out.println("Informe o ponto Y: ");
        y = sc.nextInt();
    }

    private void exibirResultado() {
        if (x == 0 && y == 0) {
            System.out.println("Quadrante 0");
        } else if (x > 0 && y > 0) {
            System.out.println("Quadrante 1");
        } else if (x > 0 && y < 0) {
            System.out.println("Quadrante 4");
        } else if (x < 0 && y < 0) {
            System.out.println("Quadrante 3");
        } else {
            System.out.println("Quadrante 2");
        }
    }


    public static void main(String[] args) {
        new Uni4Exe19();
    }
}
