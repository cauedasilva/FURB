import java.util.Arrays;
import java.util.Scanner;

public class Uni6Exe04 {
    Scanner sc = new Scanner(System.in);
    int numerosPrimeiro[] = new int[10];
    int numerosSegundo[] = new int[10];
    int numerosSomados[] = new int[10];

    public Uni6Exe04() {
        inserirValores();
        somarVetores();
        exibirResultado();
    }

    public void inserirValores() {
        for (int i = 0; i < numerosPrimeiro.length; i++) {
            System.out.println("Informe o número " + (i + 1) + " do primeiro vetor:");
            numerosPrimeiro[i] = sc.nextInt();
        }
        for (int i = 0; i < numerosSegundo.length; i++) {
            System.out.println("Informe o número " + (i + 1) + " do segundo vetor:");
            numerosSegundo[i] = sc.nextInt();
        }
    }

    public void exibirResultado() {
        System.out.println("Primeiro vetor:" + Arrays.toString(numerosPrimeiro));
        System.out.println("Segundo vetor:" + Arrays.toString(numerosSegundo));
        System.out.println("Terceiro vetor:" + Arrays.toString(numerosSomados));
    }

    private void somarVetores() {
        for (int i = 0; i < numerosSomados.length; i++) {
            numerosSomados[i] = numerosPrimeiro[i] + numerosSegundo[i];
        }
    }

    public static void main(String[] args) {
        new Uni6Exe04();
    }
}
