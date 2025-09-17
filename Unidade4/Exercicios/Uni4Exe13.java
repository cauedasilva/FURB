import java.util.Scanner;

public class Uni4Exe13 {
    Scanner sc = new Scanner(System.in);
    int num1, num2, num3, quantidadeCartasBoas;
    
    public Uni4Exe13() {
        informarValores();
        exibirResultado();
    }

    private void exibirResultado() {
        if (num1 == 1 || num1 == 2 || num1 == 3) {
            quantidadeCartasBoas += 1;
        } 
        if (num2 == 1 || num2 == 2 || num2 == 3) {
            quantidadeCartasBoas += 1;
        }
        if (num3 == 1 || num3 == 2 || num3 == 3) {
            quantidadeCartasBoas += 1;
        }
        if (quantidadeCartasBoas == 1) {
            System.out.println("Truco");
        } else if (quantidadeCartasBoas == 2) {
            System.out.println("Seis");
        } else if (quantidadeCartasBoas == 3) {
            System.out.println("Nove");
        } else {
            System.out.println("Nada");
        }
    }

    private void informarValores() {
        System.out.println("Informe o valor do primeiro lado: ");
        num1 = sc.nextInt();
        System.out.println("Informe o valor do segundo lado: ");
        num2 = sc.nextInt();
        System.out.println("Informe o valor do terceiro lado: ");
        num3 = sc.nextInt();
    }

    public static void main(String[] args) {
        new Uni4Exe13();
    }
}
