import java.util.Scanner;

public class Uni4Exe21 {
    Scanner sc = new Scanner(System.in);
    double altura, massa;

    public Uni4Exe21() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
       System.out.println("Insira a altura: ");
       altura = sc.nextDouble();
       System.out.println("Insira a massa do indivíduo: ");
       massa = sc.nextDouble();
    }

    private void exibirResultado() {
        double imc = massa / (altura * altura);

        if (imc < 18.5) {
            System.out.println("Magreza");
        } else if (imc < 25 && imc >= 18.5) {
            System.out.println("Saudável");
        } else if (imc < 30 && imc >= 25) {
            System.out.println("Sobrepeso");
        } else if (imc < 35 && imc >= 30) {
            System.out.println("Obesidade Grau I");
        } else if (imc < 40 && imc >= 35) {
            System.out.println("Obesidade Grau II (severa)");
        } else {
            System.out.println("Obesidade Grau III (mórbida)");
        }
    }


    public static void main(String[] args) {
        new Uni4Exe21();
    }
}
