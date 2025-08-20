import java.util.Scanner;

public class Uni2Exe04 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a primeira nota: ");
        double nota1 =  teclado.nextDouble();
        System.out.println("Digite a segunda nota: ");
        double nota2 =  teclado.nextDouble();
        double media = ((nota1 * 3.5f) + (nota2 * 7.5f)) / 11;
        System.out.printf("A média deste aluno é: %.2f", media);
        teclado.close();
    }
}
/*
 * Inserido nota 1: 8 e nota 2: 4, resultado esperado: 5,27
 */