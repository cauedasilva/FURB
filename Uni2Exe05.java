import java.util.Scanner;

public class Uni2Exe05 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o primeiro valor: ");
        int val1 =  teclado.nextInt();
        System.out.println("Digite o segundo valor: ");
        int val2 =  teclado.nextInt();
        System.out.println("Digite o terceiro valor: ");
        int val3 =  teclado.nextInt();
        System.out.println("Digite o quarto valor: ");
        int val4 =  teclado.nextInt();
        int resultado = (val1 * val2) - (val3 * val4);
        System.out.println("A diferença entre os valores é:" + resultado);
        teclado.close();
    }
}
/*
 * Inserido valores: 8, 6, 4 e 2 respectivmente, resultado esperado: 40
 */