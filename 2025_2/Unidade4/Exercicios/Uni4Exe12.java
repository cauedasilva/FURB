import java.util.Scanner;

public class Uni4Exe12 {
    Scanner sc = new Scanner(System.in);
    int lado1, lado2, lado3;

    public Uni4Exe12() {
        informarValores();
        exibirResultado();
    }

    private void exibirResultado() {
        if (lado1 < (lado2 + lado3) && lado2 < (lado1 + lado3) && lado3 < (lado1 + lado2)) {
            if (lado1 == lado2 && lado1 == lado3) {
                System.out.println("É equilátero.");
            } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
                System.out.println("É isósceles");
            } else {
                System.out.println("É escaleno.");
            }
        } else {
            System.out.println("Não formam um triângulo.");
        }
    }

    private void informarValores() {
        System.out.println("Informe o valor do primeiro lado: ");
        lado1 = sc.nextInt();
        System.out.println("Informe o valor do segundo lado: ");
        lado2 = sc.nextInt();
        System.out.println("Informe o valor do terceiro lado: ");
        lado3 = sc.nextInt();
    }

    public static void main(String[] args) {
        new Uni4Exe12();
    }
}
