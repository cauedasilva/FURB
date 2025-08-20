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
        float salarioLiquido = salarioBruto * 0.865f;
        System.out.printf("Funcionário: %s%n", nome);
        System.out.printf("Salário bruto: R$ %d %n", salarioBruto);
        System.out.printf("Salário líquido: R$ %.2f %n", salarioLiquido);
        teclado.close();
    }
}
