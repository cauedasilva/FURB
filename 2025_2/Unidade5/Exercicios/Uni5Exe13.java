import java.util.Scanner;

public class Uni5Exe13 {
    Scanner sc = new Scanner(System.in);
    int reabastecimentos, parada;
    float quilometragem, litros, totalKm, totalLitros;

    public Uni5Exe13() {
        inserirValor();
    }

    private void inserirValor() {
        System.out.println("Digite o número de reabastecimentos: ");
        reabastecimentos = sc.nextInt();

        for (int i = 1; i <= reabastecimentos; i++) {
            parada = i;
            System.out.println("Informe a quilometragem no momento da parada " + i + ": ");
            quilometragem = sc.nextFloat();
            System.out.println("Informe a quantidade de litros abastecidos na parada " + i + ": ");
            litros = sc.nextFloat();

            exibirResultado();
        }
    }

    private void exibirResultado() {
        totalKm += quilometragem;
        totalLitros += litros;
       
        System.out.println("Parada " + parada + ": " + (quilometragem / litros) + " km por litro");

        if (parada == reabastecimentos) {
            System.out.println("Quilometragem média obtida por litro: " + (totalKm / totalLitros) + " km por litro");
        }
    }

    public static void main(String[] args) {
        new Uni5Exe13();
    }
}
