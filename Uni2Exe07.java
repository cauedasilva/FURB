import java.util.Scanner;

public class Uni2Exe07 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do vendedor: ");
        String nome =  teclado.next();
        System.out.printf("Digite o salário fixo recebido por %s: %n", nome);
        float salario = teclado.nextFloat();
        System.out.printf("Digite o valor das vendas efetuadas por %s neste mês: %n", nome);
        float vendas = teclado.nextFloat();
        salario = (vendas * 0.15f) + salario;
        System.out.printf("O total recebido por %s neste mês foi: R$ %.2f %n", nome, salario);
        teclado.close();
    }
}
/*
 * Inserido salário fixo: 1500, valor das vendas efetuadas: 1250, resultado esperado: 1687,50
 */