import java.util.Scanner;

public class Uni4Exe15 {
    Scanner sc = new Scanner(System.in);
    int meses;

    public Uni4Exe15() {
        informarValor();
        exibirResultado();
    }

    private void exibirResultado() {
        if (meses <= 12) {
            System.out.println("O funcionário irá receber 5% de reajuste");
        } else if (meses > 12 && meses <= 48) {
            System.out.println("O funcionário irá receber 7% de reajuste");
        } else {
            System.out.println("Reajuste não informado");
        }
    }

    private void informarValor() {
        System.out.println("Informe a quantidade de meses: ");
        meses = sc.nextInt();
    }

    public static void main(String[] args) {
        new Uni4Exe15();
    }
}
