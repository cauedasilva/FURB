import java.util.Scanner;

public class MediaFinal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        String nome = teclado.nextLine();
        System.out.println("Digite a nota da primeira prova: ");
        double nota1 = teclado.nextDouble();
        System.out.println("Digite a nota da segunda prova: ");
        double nota2 = teclado.nextDouble();   
        System.out.println("Digite a nota do projeto final: ");
        double nota3 = teclado.nextDouble();
        
        /* System.out.println("Digite nota do primeiro trabalho parcial: ");
        double notaparcial1 = teclado.nextDouble();
        System.out.println("Digite nota do segundo trabalho parcial: ");
        double notaparcial2 = teclado.nextDouble();
        System.out.println("Digite nota do terceiro trabalho parcial: ");
        double notaparcial3 = teclado.nextDouble();
        System.out.println("Digite nota do quarto trabalho parcial: ");
        double notaparcial4 = teclado.nextDouble();
        System.out.println("Digite nota do quinto trabalho parcial: ");
        double notaparcial5 = teclado.nextDouble();
        System.out.println("Digite nota do sexto trabalho parcial: ");
        double notaparcial6 = teclado.nextDouble();
         */
        int trabalhoparcial = 0;
        double nota4 = 0;
        while (trabalhoparcial < 6) {
            System.out.printf("Digite a nota do trabalho parcial %s: %n", trabalhoparcial += 1);
            double notaparcial = teclado.nextDouble();
            nota4 += notaparcial;
        }
        // double nota4 = (notaparcial1 + notaparcial2 + notaparcial3 + notaparcial4 + notaparcial5 + notaparcial6) / 6;
        double media = (nota1 * 0.2 + nota2 * 0.3 + nota3 * 0.3 + nota4 / 6 * 0.2);
        System.out.printf("A média do aluno %s é: %.1f %n", nome, media);
        teclado.close();
    }
}
