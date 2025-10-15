import java.util.Scanner;

public class Uni5Exe06 {
    Scanner sc = new Scanner(System.in);
    float altura;
    
    public Uni5Exe06() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("Digite a altura da pessoa " + i + ": ");
            altura += sc.nextFloat();
        }
    }

    private void exibirResultado() {
        System.out.println("A média das alturas é: " + altura / 20);
    }

    public static void main(String[] args) {
        new Uni5Exe06();
    }
}
