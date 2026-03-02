import java.util.Scanner;

public class Uni2Exe17 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do funcionário: ");
        String nome = teclado.nextLine();
        System.out.println("Digite o número de horas trabalhadas: ");
        int horasTrabalhadas = teclado.nextInt();
        System.out.println("Digite número de dependentes: ");
        int dependentes = teclado.nextInt();
        int salario = horasTrabalhadas * 10;
        int salarioFamilia = dependentes * 60;
        int salarioBruto = salario + salarioFamilia;
        float descontoRenda = salario * 0.05f;
        float descontoInss = salario * 0.085f;
        float salarioLiquido = salarioBruto - (descontoRenda + descontoInss);
        System.out.printf("Funcionário: %s%n", nome);
        System.out.printf("Salário bruto: R$ %d %n", salarioBruto);
        System.out.printf("Salário líquido: R$ %.2f %n", salarioLiquido);
        teclado.close();
    }
}
/*
 * Inserido número de horas trabalhadas: 120, número de dependentes: 3
 * Resultado esperado: 
 * Salário bruto: R$ 1380
    Salário líquido: R$ 1218.00
 */