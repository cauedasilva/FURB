import java.util.Scanner;

public class Uni5Exe17 {
    Scanner sc = new Scanner(System.in);
    int num, maiorNum, menorNum, contMedia;
    float altura, maiorAltura, menorAltura, mediaTotal, somaAlturas;

    public Uni5Exe17() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        while (true) {
            System.out.println("Nº de inscrição: ");
            num = sc.nextInt();
            if (num == 0) {
                break;
            }
            System.out.println("Informe a altura: ");
            altura = sc.nextFloat();
        
            elencarAlturas();
        }
    }

    private void elencarAlturas() {
        if (maiorAltura == 0 && menorAltura == 0) {
            maiorAltura = altura;
            maiorNum = num;
            menorAltura = altura;
            menorNum = num;
        } else if (altura > maiorAltura) {
            maiorAltura = altura;
            maiorNum = num;
        } else if (altura < menorAltura) {
            menorAltura = altura;
            menorNum = num;
        }

        contMedia++;
        somaAlturas += altura;
    }

    private void exibirResultado() {
        mediaTotal = somaAlturas / contMedia;
        System.out.println("O atleta mais baixo tem " + menorAltura + "m e o seu número de inscrição é: " + menorNum);
        System.out.println("O atleta mais alto tem " + maiorAltura + "m e o seu número de inscrição é: " + maiorNum);
        System.out.println("A altura média do grupo de atletas é: " + mediaTotal);
    }

    public static void main(String[] args) {
        new Uni5Exe17();
    }
}
