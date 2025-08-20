import java.util.Scanner;

public class Uni2Exe20 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escreva o número de dobras no papel: ");
        int dobras = teclado.nextInt();
        double quadrados = Math.pow(2, dobras);
        System.out.println("O número de quadrados no papel são: " + quadrados);
        teclado.close();
    }
}
/* 
 * Inserido dobras 4, resultado esperado: 16
 */
