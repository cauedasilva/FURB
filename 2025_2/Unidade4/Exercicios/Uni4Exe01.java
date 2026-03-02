import java.util.Scanner;

public class Uni4Exe01 {
    Scanner sc = new Scanner(System.in);
    double horasTrabalhadas, valorPorHora, salarioTotal;
    
    public Uni4Exe01() {
        informarValores();
        salarioTotal();
        exibirResultado();
    }

    private void exibirResultado() {
        System.out.println("O salário total é: " + salarioTotal);
    }

    private void salarioTotal() {
        double salarioExtra = 0;
        if (horasTrabalhadas > 160) {
            salarioExtra = (horasTrabalhadas - 160) * (valorPorHora / 2);
        }
        salarioTotal = (horasTrabalhadas * valorPorHora) + salarioExtra;
    }

    private void informarValores() {
        System.out.println("Informe as horas trabalhadas em um mês: ");
        horasTrabalhadas = sc.nextDouble();
        System.out.println("Informe o valor recebido por hora em R$: ");
        valorPorHora = sc.nextDouble();
    }

    public static void main(String[] args) {
        new Uni4Exe01();
    }
}
