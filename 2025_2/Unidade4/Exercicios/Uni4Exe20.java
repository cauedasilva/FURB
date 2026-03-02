import java.util.Scanner;

public class Uni4Exe20 {
    Scanner sc = new Scanner(System.in);
    double a, b, c, d;

    public Uni4Exe20() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
       System.out.println("Insira as três notas do aluno: ");
       a = sc.nextDouble();
       b = sc.nextDouble();
       c = sc.nextDouble();
       System.out.println("Insira a nota dos exercícios: ");
       d = sc.nextFloat();
    }

    private void exibirResultado() {
        double media = (a + (b * 2) + (c * 3) + d) / 7;
        if (media >= 9) {
            System.out.printf("A média de aproveitamento foi %.2f. Conceito A. Aprovado", media);
        } else if (media >= 7.5 && media < 9) {
            System.out.printf("A média de aproveitamento foi %.2f. Conceito B. Aprovado", media);
        } else if (media >= 6 && media < 7.5) {
            System.out.printf("A média de aproveitamento foi %.2f. Conceito C. Aprovado", media);
        } else if (media >= 4 && media < 6) {
            System.out.printf("A média de aproveitamento foi %.2f. Conceito D. Reprovado", media);
        } else {
            System.out.printf("A média de aproveitamento foi %.2f. Conceito E. Reprovado", media);
        }
    }


    public static void main(String[] args) {
        new Uni4Exe20();
    }
}
