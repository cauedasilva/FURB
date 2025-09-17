import java.util.Scanner;

public class Uni4Exe02 {
    Scanner sc = new Scanner(System.in);
    int num;
    
    public Uni4Exe02() {
        informarValor();
        exibirResultado();
    }

    private void exibirResultado() {
        if (num % 2 == 0) {
            System.out.println("Número é par");
        } else {
            System.out.println("Número é impar");
        }
    }

    private void informarValor() {
        System.out.println("Informe um valor inteiro maior que 0: ");
        num = sc.nextInt();
    }

    public static void main(String[] args) {
        new Uni4Exe02();
    }
}
