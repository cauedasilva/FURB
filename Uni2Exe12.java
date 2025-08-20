import java.util.Scanner;

public class Uni2Exe12 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o primeiro valor X: ");
        float x1 = teclado.nextFloat();
        System.out.println("Digite o primeiro valor Y: ");
        float y1 = teclado.nextFloat();
        System.out.println("Digite o segundo valor X: ");
        float x2 = teclado.nextFloat();
        System.out.println("Digite o segundo valor Y: ");
        float y2 = teclado.nextFloat();
        double x = Math.pow((x2 - x1), 2);
        double y = Math.pow((y2 - y1), 2);
        double distancia = Math.sqrt(x + y);
        System.out.printf("A distância é: %.4f", distancia);
        teclado.close();
    }
}
/* 
 * Inserido valores 2, 4, 6, 8, respectivamente, resultado esperado: 5,6569
 */