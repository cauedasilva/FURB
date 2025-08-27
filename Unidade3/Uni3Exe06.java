import java.util.Scanner;

public class Uni3Exe06 {
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        float peso = lerPeso();
        float valorPago = calcularValorPago(peso);
        exibirResultado(valorPago);
        teclado.close();
    }

    public static float lerPeso() {
        System.out.println("Digite o peso em kg: ");
        float peso = teclado.nextFloat();
        return peso;
    }

    public static float calcularValorPago(float peso) {
        float valorPago = (peso - 0.75f) * 25;
        return valorPago;
    }

    public static void exibirResultado(float valorPago) {
        System.out.printf("O valor do prato do cliente é R$%.2f", valorPago);
    }
}
