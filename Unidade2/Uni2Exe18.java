import java.util.Scanner;

public class Uni2Exe18 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o comprimento da parede em metros: ");
        int comprimento = teclado.nextInt();
        System.out.println("Digite a altura da parede em metros: ");
        int altura = teclado.nextInt();
        int area = altura * comprimento;
        int azulejos = area * 9;
        float valor = azulejos * 12.50f;
        System.out.printf("O valor gasto em azulejos é de: R$ %.2f", valor);
        teclado.close();
    }
}

/*
 * Inserido comprimento: 5, e altura: 7
 * Resultado esperado: R$ 3937.50
 */