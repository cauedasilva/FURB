import java.util.Scanner;

public class Uni6Exe08 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;

    public Uni6Exe08() {
        inserirValores();
    }

    private void inserirValores() {
        System.out.println("Informe o tamanho do vetor de números reais (entre 0 e 20): ");
        while (continuar) {
            double numeros[] = new double[sc.nextInt()];
            if (numeros.length > 20 || numeros.length < 0) {
                System.out.println("O número deve estar entre 0 e 20");
            } else {
                for (int i = 0; i < numeros.length; i++) {
                    System.out.println("Informe o número da posição " + i + ":");
                    numeros[i] = sc.nextDouble();
                }
                System.out.println("Valor | Frequência");
                medirFrequencia(numeros);
                continuar = false;
                break;
            }
        }
    }

    private void medirFrequencia(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int frequencia = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    frequencia++;
                }
            }
            exibirResultado(arr, frequencia, i);
        }
    }

    private void exibirResultado(double[] arr, int frequencia, int i) {
        System.out.println(arr[i] + "   " + frequencia);
    }

    public static void main(String[] args) {
        new Uni6Exe08();
    }
}
