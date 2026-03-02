import java.util.Scanner;

public class Uni4Exe17 {
    Scanner sc = new Scanner(System.in);
    double renda, dependentes, imposto;

    public Uni4Exe17() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Informe a renda atual: ");
        renda = sc.nextFloat();
        System.out.println("Informe a quantidade de dependentes: ");
        dependentes = sc.nextInt();
    }

    private void exibirResultado() {
        double desconto = renda * ((dependentes/100) * 2);
        double rendaLiquida = renda - desconto;

        if (renda <= 2000) {
            System.out.println("O imposto é de 0%: R$ 0.00");
        } else if (renda > 2000 && renda <= 5000) {
            imposto = rendaLiquida * 0.05;
            System.out.println("O imposto é de 5%: R$ " + imposto);
        } else if (renda > 5000 && renda <= 10000) {
            imposto = rendaLiquida * 0.1;
            System.out.println("O imposto é de 10%: R$ " + imposto);
        } else {
            imposto = rendaLiquida * 0.15;
            System.out.println("O imposto é de 15%: R$ " + imposto);
        }
    }


    public static void main(String[] args) {
        new Uni4Exe17();
    }
}
