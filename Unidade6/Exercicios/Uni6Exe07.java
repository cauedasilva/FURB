import java.util.Scanner;

public class Uni6Exe07 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;

    public Uni6Exe07() {
        inserirValores();
    }

    private void inserirValores() {
        System.out.println("Informe o tamanho do vetor de números inteiros (entre 0 e 20): ");
        while (continuar) {
            int numeros[] = new int[sc.nextInt()];
            if (numeros.length > 20 || numeros.length < 0) {
                System.out.println("O número deve estar entre 0 e 20");
            } else {
                int i = 0;
                while (i < numeros.length) {
                    System.out.println("Informe o número da posição " + i + ":");
                    int num = sc.nextInt();
                    if (!igualVetor(numeros, i, num)) {
                        numeros[i] = num;
                        i++;
                    } else {
                        System.out.println("Este número já existe no vetor.");
                    }
                }
                ordenarVetor(numeros);
                continuar = false;
                break;
            }
        }
    }

    private boolean igualVetor(int[] arr, int limite, int valor) {
        for (int i = 0; i < limite; i++) {
            if (arr[i] == valor) {
                return true;
            }
        }
        return false;
    }

    private void ordenarVetor(int[] arr) {
        int temp;
        boolean trocado = false;
        for (int i = 0; i < arr.length - 1; i++) {
            trocado = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocado = true;
                }
            }

            if (trocado == false) {
                break;
            }
        }
        exibirResultado(arr);
    }

    private void exibirResultado(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        new Uni6Exe07();
    }
}
