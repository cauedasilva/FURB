import java.util.Scanner;

public class Uni6Exe01 {
    Scanner sc = new Scanner(System.in);
    int numeros[] = new int[10];
    
    public Uni6Exe01() {
        inserirValores();
        exibirResultado();
    }

    public void inserirValores() {
        for (int i = 1; i <= numeros.length; i++) {
            System.out.println("Informe o número " + i + ":");
            numeros[numeros.length - i] = sc.nextInt();
        }
    }

    public void exibirResultado() {
        for (int i = 1; i <= numeros.length; i++) {
            System.out.println("Posição " + (numeros.length - i) + ": " + numeros[i - 1]);
        }
    }

    public static void main(String[] args) {
        new Uni6Exe01();
    }
}
