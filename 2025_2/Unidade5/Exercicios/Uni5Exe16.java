import java.util.Scanner;

public class Uni5Exe16 {
    Scanner sc = new Scanner(System.in);
    char gen;
    float altura, totalAltura, totalAlturaMulheres, mediaMulheres, mediaTotal;
    int contMulheres, contOutros;
    boolean continuar = true;

    public Uni5Exe16() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        while (continuar) {
            System.out.println("Informe a altura: ");
            altura = sc.nextFloat();
            if (altura == 0) {
                continuar = false;
                break;
            }
            System.out.println("Informe o gênero: ");
            gen = sc.next().toUpperCase().charAt(0);

            calcularAltura();
        }
    }

    private void calcularAltura() {
        if (gen == 'F') {
            totalAlturaMulheres += altura;
            contMulheres++;
        } else {
            totalAltura += altura;
            contOutros++;
        }
    }

    private void exibirResultado() {
        mediaMulheres = totalAlturaMulheres / contMulheres;
        mediaTotal = totalAltura / contOutros;
        if (totalAlturaMulheres != 0) {
            System.out.println("A média da altura das mulheres é: " + mediaMulheres);
        } else {
            System.out.println("Não foram inseridos valores para o grupo de mulheres");
        }
        if (totalAltura != 0) {
            System.out.println("A média de altura do grupo é: " + mediaTotal);
        } else {
            System.out.println("Não foram inseridos valores para este grupo");
        }
    }

    public static void main(String[] args) {
        new Uni5Exe16();
    }
}
