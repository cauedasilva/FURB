import java.util.Scanner;

public class Uni6Exe02 {
    Scanner sc = new Scanner(System.in);
    double numeros[] = new double[12];
    double media;
    
    public Uni6Exe02() {
        inserirValores();
        calcularMedia();
        exibirResultado();
    }

    public void inserirValores() {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Informe o número " + (i + 1) + ":");
            numeros[i] = sc.nextDouble();
        }
    }

    public void exibirResultado() {
        System.out.println("A média é: " + media);
        System.out.println("Números maiores que a média: ");
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > media) {
                System.out.println(numeros[i]);
            }
        }
    }

    private void calcularMedia() {
        for (int i = 0; i < numeros.length; i++) {
            media += numeros[i];
        }

        media = media / numeros.length;
    }

    public static void main(String[] args) {
        new Uni6Exe02();
    }
}
