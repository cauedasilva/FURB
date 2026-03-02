import java.util.Scanner;

public class Uni2Exe15 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o valor: ");
        float valorTotal = teclado.nextFloat();
        float valor = valorTotal;
        float cedulas100 = (int) valor / 100;
        valor %= 100;
        float cedulas50 = (int) valor / 50;
        valor %= 50;
        float cedulas20 = (int) valor / 20; 
        valor %= 20;
        float cedulas10 = (int) valor / 10;
        valor %= 10;
        float cedulas5 = (int) valor / 5;
        valor %= 5;
        float cedulas2 = (int) valor / 2;
        valor %= 2;
        float moedas1 = (int) valor;
        valor %= 1;
        valor = (float) Math.round(valor * 100);
        float moedas50 = (int) valor / 50;
        valor %= 50;
        float moedas25 = (int) valor / 25;
        valor %= 25;
        float moedas10 = (int) valor / 10;
        valor %= 10;
        float moedas05 = (int) valor / 5;
        valor %= 5;
        float moedas01 = (int) valor / 1;
        System.out.printf("Para o valor de R$ %.2f, serão necessárias: %n", valorTotal);
        System.out.printf("Notas de 100: %.0f %n", cedulas100);
        System.out.printf("Notas de 50: %.0f %n", cedulas50);
        System.out.printf("Notas de 20: %.0f %n", cedulas20);
        System.out.printf("Notas de 10: %.0f %n", cedulas10);
        System.out.printf("Notas de 5: %.0f %n", cedulas5);
        System.out.printf("Notas de 2: %.0f %n", cedulas2);
        System.out.printf("Moedas de 1: %.0f %n", moedas1);
        System.out.printf("Moedas de 0.50: %.0f %n", moedas50);
        System.out.printf("Moedas de 0.25: %.0f %n", moedas25);
        System.out.printf("Moedas de 0.10: %.0f %n", moedas10);
        System.out.printf("Moedas de 0.05: %.0f %n", moedas05);
        System.out.printf("Moedas de 0.01: %.0f %n", moedas01);
        teclado.close();
    }
}
/*
 * Inserido valor: 233.57, resultado esperado:
 * Notas de 100: 2
Notas de 50: 0
Notas de 20: 1
Notas de 10: 1
Notas de 5: 0
Notas de 2: 1
Moedas de 1: 1
Moedas de .50: 1
Moedas de .25: 0
Moedas de .10: 0
Moedas de .05: 1
Moedas de .01: 2
 */