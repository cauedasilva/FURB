import java.util.Scanner;

public class Uni4Exe04 {
    Scanner sc = new Scanner(System.in);
    double num;

    public Uni4Exe04() {
        informarValor();
        exibirResultado();
    }

    private void exibirResultado() {
        if (num % 1 == 0) {
            System.out.println("Casas decimais não foram digitadas.");
        } else {
            System.out.println("Casas decimais foram digitadas.");
        }
    }

    private void informarValor() {
        System.out.println("Informe um número de ponto flutuante maior do que 0: ");
        num = sc.nextDouble();
    }

    public static void main(String[] args) {
        new Uni4Exe04();
    }
}
