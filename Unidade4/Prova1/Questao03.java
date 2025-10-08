import java.util.Scanner;

public class Questao03 {
    Scanner sc = new Scanner(System.in);
    char codigo;

    public Questao03() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Informe o código do carro: ");
        codigo = sc.next().toUpperCase().charAt(0);
    }

    private void exibirResultado() {
        if (codigo == 'A') {
            System.out.println("Porsche");
        } else if (codigo == 'B') {
            System.out.println("Fusca");
        } else if (codigo == 'C') {
            System.out.println("Gol");
        } else {
            System.out.println("Entrada Incorreta");
        }
    }

    public static void main(String[] args) {
        new Questao03();
    }
}
