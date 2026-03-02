import java.util.Scanner;

public class Uni4Exe05 {
    Scanner sc = new Scanner(System.in);
    boolean resposta;

    public Uni4Exe05() {
        informarValor();
        exibirResultado();
    }

    private void exibirResultado() {
        if (resposta) {
            System.out.println("Sim");
        } else if (resposta == false) {
            System.out.println("Não");
        }
    }

    private void informarValor() {
        System.out.println("A cor é azul?");
        resposta = sc.nextBoolean();
    }

    public static void main(String[] args) {
        new Uni4Exe05();
    }   
}
