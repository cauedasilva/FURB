import java.util.Scanner;

public class Uni2Exe16 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o número de latas compradas: ");
        int latas = teclado.nextInt();
        System.out.println("Digite o número de garrafas de 600ml compradas: ");
        int garrafas600 = teclado.nextInt();
        System.out.println("Digite o número de garrafas de 2L compradas: "); 
        int garrafas2000 = teclado.nextInt();
        float totalLitros = (latas * 0.35f) + (garrafas600 * 0.6f) + (garrafas2000 * 2);
        System.out.println("Total de litros comprados: " + totalLitros);
        teclado.close();
    }
}
/*
 * Inserido valores: 10 latas, 5 garrafas de 600ml, 2 garrafas de 2L, resultado esperado: 
 * Total de litros comprados: 10.5
 */