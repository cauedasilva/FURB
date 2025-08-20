import java.util.Scanner;

public class Uni2Exe03 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o valor do raio: ");
        double num1 =  teclado.nextDouble();
        System.out.println("O valor da cincurferência é: " + ((Math.pow(num1, 2)) * Math.PI));
        teclado.close();
    }
}
/*
 * Inserido raio 2, resultado esperado: 12.566370614359172
 */