import java.util.Scanner;

public class Uni5Exe26 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    double valor, valorLimite, distancia;
    int quantidadeDeTrechos, quantidadeLimite, quantidade150;

    public Uni5Exe26() {
        inserirValores();
        exibirResultado();
    }

    private void inserirValores() {
        System.out.println("Informe qual o valor limite do pedágio: ");
        valorLimite = sc.nextDouble();

        while (continuar) {
            for (int i = 0; i < 2; i++) {
                System.out.println("Pedágio: ");
                valor = sc.nextDouble();
                if (valor < 0) {
                    continuar = false;
                    break;
                } else if (valor > valorLimite) {
                    quantidadeLimite++;
                }
                System.out.println("Distância em km: ");
                distancia = sc.nextDouble();
                if (distancia > 150 && valor < valorLimite) {
                    quantidade150++;
                }
                quantidadeDeTrechos++;
            }
        }

    }

    private void exibirResultado() {
        System.out.println("Trechos com valor acima do qual ele nega-se a pagar: " + quantidadeLimite);
        System.out.println("Quantidade de trechos informados: " + quantidadeDeTrechos);
        System.out.println("Trechos acima de 150km com valor aceito: " + quantidade150);
    }

    public static void main(String[] args) {
        new Uni5Exe26();
    }
}
