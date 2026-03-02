import java.util.Scanner;

public class Uni3Exe03 {
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        float valorLitros = lerLitros();
        float valorPago = lerValor();
        exibirResultado(valorLitros, valorPago);
        teclado.close();
    }

    public static float lerLitros() {
        System.out.println("Digite o valor do litro de gasolina: ");
        float litros = teclado.nextFloat();
        return litros;
    }

    public static float lerValor() {
        System.out.println("Digite o valor pago: ");
        float valor = teclado.nextFloat();
        return valor;
    }

    public static void exibirResultado(float valorLitros, float valor) {
        float litros = valor / valorLitros;
        System.out.printf("O motorista conseguiu colocar: %.2f litros.", litros);
    }
}
