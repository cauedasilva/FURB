import java.util.Scanner;

public class Uni2Exe14 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o valor: ");
        int valorTotal = teclado.nextInt();
        int valor = valorTotal;
        int cedulas100 = valor / 100;
        valor %= 100;
        int cedulas50 = valor / 50;
        valor %= 50;
        int cedulas20 = valor / 20; 
        valor %= 20;
        int cedulas10 = valor / 10;
        valor %= 10;
        int cedulas5 = valor / 5;
        valor %= 5;
        int cedulas2 = valor / 2;
        valor %= 2;
        int cedulas1 = valor;
        System.out.printf("Para o valor de R$ %d, serão necessárias: %n", valorTotal);
        System.out.printf("Notas de 100: %d %n", cedulas100);
        System.out.printf("Notas de 50: %d %n", cedulas50);
        System.out.printf("Notas de 20: %d %n", cedulas20);
        System.out.printf("Notas de 10: %d %n", cedulas10);
        System.out.printf("Notas de 5: %d %n", cedulas5);
        System.out.printf("Notas de 2: %d %n", cedulas2);
        System.out.printf("Moedas de 1: %d %n", cedulas1);
        teclado.close();
    }
}
/*
 * Inserido valor: 233, resultado esperado:
 * Notas de 100: 2
Notas de 50: 0
Notas de 20: 1
Notas de 10: 1
Notas de 5: 0
Notas de 2: 1
Moedas de 1: 1
 */