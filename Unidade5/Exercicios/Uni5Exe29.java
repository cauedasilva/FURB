import java.util.Scanner;

public class Uni5Exe29 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    double valor, valorOriginal;
    int cedulaVinte, cedulaDez, cedulaCinco, cedulaDois, cedulaUm;

    public Uni5Exe29() {
        inserirValores();
    }

    private void inserirValores() {
        while (continuar) {
            System.out.println("Insira o valor a ser sacado: ");
            valor = sc.nextDouble();
            calcularCedulas();
            System.out.println("Deseja realizar um novo saque? s(SIM) / n(NÃO)");
            char opcao = sc.next().toLowerCase().charAt(0);
            if (opcao == 'n') {
                continuar = false;
                break;
            }
        }
    }

    private void calcularCedulas() {
        valorOriginal = valor;
        cedulaVinte = (int) (valor / 20);
        valor %= 20;
        cedulaDez = (int) (valor / 10);
        valor %= 10;
        cedulaCinco = (int) (valor / 5);
        valor %= 5;
        cedulaDois = (int) (valor / 2);
        valor %= 2;
        cedulaUm = (int) (valor / 1);
        valor %= 1;
        exibirResultado();
    }

    private void exibirResultado() {
        System.out.println("Para o valor de R$ " + valorOriginal + " serão necessárias as seguintes cédulas:");
        System.out.println("Cédulas de R$ 20: " + cedulaVinte);
        System.out.println("Cédulas de R$ 10: " + cedulaDez);
        System.out.println("Cédulas de R$ 5: " + cedulaCinco);
        System.out.println("Cédulas de R$ 2: " + cedulaDois);
        System.out.println("Cédulas de R$ 1: " + cedulaUm);
    }

    public static void main(String[] args) {
        new Uni5Exe29();
    }
}
