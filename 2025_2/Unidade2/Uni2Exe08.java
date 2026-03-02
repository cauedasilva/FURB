import java.util.Scanner;

public class Uni2Exe08 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o código da peça 1: ");
        String cod1 = teclado.next();
        System.out.printf("Digite o número de peças com o código %s: ", cod1);
        int num1 = teclado.nextInt();
        System.out.printf("Digite o valor unitário da peça com código %s: ", cod1);
        float val1 = teclado.nextFloat();
        System.out.println("Digite o código da peça 2: ");
        String cod2 = teclado.next();
        System.out.printf("Digite o número de peças com o código %s: ", cod2);
        int num2 = teclado.nextInt();
        System.out.printf("Digite o valor unitário da peça com código %s: ", cod2);
        float val2 = teclado.nextFloat();
        float total = (num1 * val1) + (num2 * val2);
        System.out.println("O valor total a ser pago é: " + total);
        teclado.close();
    }
}
/*
 * Inserido número de peças 1: 20, valor: 54,50
 * número de peças 2: 25, valor: 19,99
 * resultado esperado: 1589,75
 */