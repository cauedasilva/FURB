import java.util.Scanner;

public class Uni2Exe19 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Insira o valor de B: ");
        int b = teclado.nextInt();
        System.out.println("Insira o valor de C: ");
        int c = teclado.nextInt();
        System.out.println("Insira o valor de D: ");
        int d = teclado.nextInt();
        int a = b;
        System.out.println("O valor de A é: " + a);
        teclado.close();
    }
}
/*
 * Inserido valores B: 5, C: 10, D: 15
 * Resultado esperado A: 5
 */