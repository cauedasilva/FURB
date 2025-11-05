import java.util.Scanner;

public class Uni6Exe06 {
    Scanner sc = new Scanner(System.in);

    public Uni6Exe06() {
        inserirValores();
    }

    public void inserirValores() {
        System.out.println("Informe o tamanho do vetor de números reais: ");
        double numeros[] = new double[sc.nextInt()];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Informe o número da posição " + i + ":");
            numeros[i] = sc.nextDouble();
        }
        System.out.println("Informe um número real para validar se está no vetor:");
        exibirResultado(sc.nextDouble(), numeros);
    }

    public void exibirResultado(double num, double[] numeros) {
        boolean valor = false;

        for (int i = 0; i < numeros.length; i ++) {
            if (numeros[i] == num) {
                valor = true;
            }
        }

        if (valor == true) {
            System.out.println("Verdadeiro");
        } else {
            System.out.println("Falso");
        }
    }

    public static void main(String[] args) {
        new Uni6Exe06();
    }
}
