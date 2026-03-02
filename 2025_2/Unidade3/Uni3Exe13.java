import java.util.Scanner;

public class Uni3Exe13 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        float altura = lerMedida("Altura");
        float comprimento = lerMedida("Comprimento");
        float valor = calcularValor(altura, comprimento);
        exibirResultado(valor);
        teclado.close();
    }

    public static float lerMedida(String medida) {
        System.out.println(medida + ": ");
        float valor = teclado.nextFloat();
        return valor;
    }

    public static float calcularValor(float altura, float comprimento) {
        float area = altura * comprimento;
        float azulejos = area * 9;
        float valor = azulejos * 12.50f;
        return valor;
    }

    public static void exibirResultado(float valor) {
        System.out.printf("O valor final é R$%.2f", valor);
    }
}
