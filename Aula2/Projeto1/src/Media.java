import java.util.Scanner;

public class Media {    
    public static void main(String[] args) {
        // Professor quer receber o nome do aluno e três notas
        // Calcular média e exibir o nome do aluno e a média do mesmo
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        String nome = teclado.nextLine();
        System.out.println("Digite a primeira nota: ");
        double nota1 = teclado.nextDouble();
        System.out.println("Digite a segunda nota: ");
        double nota2 = teclado.nextDouble();   
        System.out.println("Digite a terceira nota: ");
        double nota3 = teclado.nextDouble();
        double media = (nota1 + nota2 + nota3) / 3;
        System.out.printf("A média do aluno %s é: %.2f%n", nome, media);
        teclado.close();
        if (media >= 6) {
            System.out.println("Aluno aprovado!");
        } else if (media >= 5) {
            System.out.println("Aluno em recuperação!");
        } else {
            System.out.println("Aluno reprovado!");
        }
    }
}
