import java.util.Scanner;

public class Uni5Exe21 {
    Scanner sc = new Scanner(System.in);
    double massa, massaInicial;
    int segundos; 

    public Uni5Exe21() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        System.out.println("Informe a massa inicial do material (em kg): ");
        massa = sc.nextFloat();
        massaInicial = massa;
        while (massa >= 0.0005) {
            massa /= 2;
            segundos += 50;
        }
    }

    private void exibirResultado() {
        System.out.println("Tempo necessário para a massa atingir menos de 0,5g: " + segundos / 60 + " minutos e " + segundos % 60 + " segundos.");
        System.out.println("massa inicial: " + massaInicial + " kg.");
        System.out.println("massa final: " + massa + " kg.");
    }

    public static void main(String[] args) {
        new Uni5Exe21();
    }
}
