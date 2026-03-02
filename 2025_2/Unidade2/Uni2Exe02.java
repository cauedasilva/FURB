import java.util.Scanner;

public class Uni2Exe02 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o primeiro número: ");
        int num1 =  teclado.nextInt();
        System.out.println("Digite o segundo número: ");
        int num2 = teclado.nextInt();
        System.out.println("A multiplicação dos números é: " + (num1 * num2));
        teclado.close();
    }
}
/*
 * Inserido números 10 e 2, resultado esperado: 20
 */