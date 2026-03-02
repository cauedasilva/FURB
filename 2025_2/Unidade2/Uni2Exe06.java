import java.util.Scanner;

public class Uni2Exe06 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do funcionário: ");
        String nome =  teclado.next();
        System.out.printf("Digite o número de horas trabalhadas por %s: %n", nome);
        int horas = teclado.nextInt();
        System.out.println("Escreva o valor recebido por hora: ");
        double valor = teclado.nextDouble();
        double salario = horas * valor;
        System.out.printf("O funcionário %s recebeu neste mês o valor de: R$ %.2f", nome, salario);
        teclado.close();
    }
}
/*
 * Inserido horas trabalhadas: 120 e valor recebido por hora: 15, resultado esperado: 1800,00
 */