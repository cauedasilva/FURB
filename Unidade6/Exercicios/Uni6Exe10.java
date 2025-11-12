import java.util.Scanner;

public class Uni6Exe10 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    int numeros[] = new int[50];
    int posicao = 0;

    public Uni6Exe10() {
        inserirValores();
    }

    private void inserirValores() {
        do {
            System.out.println("Menu: ");
            System.out.println("1 - Incluir valor \n2 - Pesquisar valor \n3 - Alterar valor \n4 - Excluir Valor \n5 - Mostrar valores \n6 - Ordenar valores \n7 - Inverter valores \n8 - Sair do sistema");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    incluirValor(numeros);
                    break;
                case 2:
                    pesquisarValor(numeros);
                    break;
                case 3:
                    alterarValor(numeros);
                    break;
                case 4:
                    excluirValor(numeros);
                    break;
                case 5:
                    mostrarValores(numeros);
                    break;
                case 6:
                    ordenarValores(numeros);
                    break;
                case 7:
                    inverterValores(numeros);
                    break;
                case 8:
                    continuar = false;
                    break;    
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (continuar);
    }

    private void incluirValor(int[] arr) {
        if (posicao < arr.length) {
            System.out.println("Informe o valor: ");
            arr[posicao] = sc.nextInt();
            posicao++;
        } else {
            System.out.println("Vetor está cheio.");
        }
    }

    private int pesquisarValor(int[] arr) {
        System.out.println("Informe o valor a ser pesquisado: ");
        int num = sc.nextInt();

        for (int i = 0; i < posicao; i++) {
            if (num == arr[i]) {
                System.out.println("Encontrado número na posição: numeros[" + i + "]");
                return i;
            }
        }

        System.out.println("Não encontrado número.");
        return -1;
    }

    private void alterarValor(int[] arr) {
        int num = pesquisarValor(arr);
        if (num != -1) {
            System.out.println("Informe um número a ser alterado: ");
            int valor = sc.nextInt();
            arr[num] = valor;
            System.out.println("Valor alterado no vetor.");
        }
    }

    private void excluirValor(int[] arr) {
        int num = pesquisarValor(arr);
        if (num != -1) {
            for (int i = posicao; i < (posicao - 1); i++) {
                arr[i] = arr[i + 1];
            }
            posicao--;
        }
    }

    private void mostrarValores(int[] arr) {
        for (int i = 0; i < posicao; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    private void ordenarValores(int[] arr) {
        int temp;
        boolean trocado = false;
        for (int i = 0; i < posicao - 1; i++) {
            trocado = false;
            for (int j = 0; j < posicao - i - 1; j++) {
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
    }

    private void inverterValores(int[] arr) {
        int temp;
        //boolean trocado[] = new boolean[posicao];
        for (int i = 0; i < posicao; i++) {
            /*
            if (trocado[i] == false) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                i = -1;
            }
            */
            for (int j = 0; j < i; j++) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // outro método
        /*
        for (int i = 0; i < posicao - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    i = -1;
                }
            }
        }
        */
    }


    public static void main(String[] args) {
        new Uni6Exe10();
    }
}
