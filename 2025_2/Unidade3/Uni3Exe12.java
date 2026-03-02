import java.util.Scanner;

public class Uni3Exe12 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String nome = lerNome();
        int horas = lerHoras();
        int dependentes = lerDependentes();
        float salarioTrabalho = calcularSalarioTrabalho(horas);
        float salarioBruto = calcularSalarioBruto(salarioTrabalho, dependentes);
        float salarioLiquido = calcularSalarioLiquido(salarioTrabalho, salarioBruto);
        exibirResultado(nome, salarioBruto, salarioLiquido);
        teclado.close();
    }

    public static String lerNome() {
        System.out.println("Digite o nome do funcionário: ");
        String nome = teclado.nextLine();
        return nome;
    }

    public static int lerHoras() {
        System.out.println("Quantidade de horas trabalhadas no mês: ");
        int horas = teclado.nextInt();
        return horas;
    }

    public static int lerDependentes() {
        System.out.println("Número de dependentes: ");
        int dependentes = teclado.nextInt();
        return dependentes;
    }

    public static float calcularSalarioTrabalho(int horas) {
        float salarioTrabalho = horas * 10;
        return salarioTrabalho;
    }

    public static float calcularSalarioBruto(float salarioTrabalho, int dependentes) {
        float salarioBruto = salarioTrabalho + (dependentes * 60);
        return salarioBruto;
    }

    public static float calcularSalarioLiquido(float salarioTrabalho, float salarioBruto) {
        float descontoRenda = salarioTrabalho * 0.05f;
        float descontoInss = salarioTrabalho * 0.085f;
        float salarioLiquido = salarioBruto - (descontoRenda + descontoInss);
        return salarioLiquido;
    }

    public static void exibirResultado(String nome, float salarioBruto, float salarioLiquido) {
        System.out.printf("O funcionário %s possui um salário bruto de R$%.2f e um salário líquido de R$%.2f", nome, salarioBruto, salarioLiquido);
    }

}
