import java.util.Scanner;

public class Uni2Exe18 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o comprimento da parede em metros: ");
        float comprimento = teclado.nextFloat();
        System.out.println("Digite a altura da parede em metros: ");
        float altura = teclado.nextFloat();
        float area = altura * comprimento;
        float azulejos = area * 9;
        float valor = azulejos * 12.50f;
        System.out.printf("O valor gasto em azulejos é de: R$ %.2f", valor);
        teclado.close();
    }
}

/*
 * Inserido comprimento: 5, e altura: 7
 * Resultado esperado: R$ 3937.50
 */