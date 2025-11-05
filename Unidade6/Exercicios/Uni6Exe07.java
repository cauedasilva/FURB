import java.util.Scanner;

public class Uni6Exe07 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;

    public Uni6Exe07() {
        inserirValores();
    }

    public void inserirValores() {
        System.out.println("Informe o tamanho do vetor de números inteiros (entre 0 e 20): ");
        while (continuar) {
            int numeros[] = new int[sc.nextInt()];
            if (numeros.length > 20 || numeros.length < 0) {
                System.out.println("O número deve estar entre 0 e 20");
            } else {
                for (int i = 0; i < numeros.length; i++) {
                    System.out.println("Informe o número da posição " + i + ":");
                    numeros[i] = sc.nextInt();
                }
                continuar = false;
                break;
            }
        }
    }

    public void exibirResultado() {
        
    }

    public static void main(String[] args) {
        new Uni6Exe07();
    }
}
