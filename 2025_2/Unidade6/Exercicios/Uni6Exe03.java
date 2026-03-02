import java.util.Scanner;

public class Uni6Exe03 {
    Scanner sc = new Scanner(System.in);
    double numeros[] = new double[12];

    public Uni6Exe03() {
        inserirValores();
        calcularValor();
        exibirResultado();
    }

    public void inserirValores() {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Informe o número " + (i + 1) + ":");
            numeros[i] = sc.nextDouble();
        }
    }

    public void exibirResultado() {
        System.out.println("Vetor com valores atualizados: ");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }

    private void calcularValor() {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                numeros[i] = numeros[i] * 1.02;
            } else {
                numeros[i] = numeros[i] * 1.05;
            }
        }
    }

    public static void main(String[] args) {
        new Uni6Exe03();
    }
}
