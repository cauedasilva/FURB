import java.util.Scanner;
import java.text.DecimalFormat;

public class Uni3Exe02 {
 static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        float valor = lerValor();
        float valorDesconto = calcularDesconto(valor);
        float valorFinal = calcularValorFinal(valor, valorDesconto);
        exibirResultado(valorDesconto, valorFinal);
        teclado.close();
    }

    public static float lerValor() {
        System.out.println("Escreva o valor do produto: ");
        float valor = teclado.nextFloat();
        return valor;
    }

    public static float calcularDesconto(float valor) {
        return valor * 0.12f;
    }

    public static float calcularValorFinal(float valor, float valorDesconto) {
        return valor - valorDesconto;
    }
    
    public static void exibirResultado(float valorDesconto, float valorFinal) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("O valor do desconto é de R$" + valorDesconto);
        System.out.println("O preço do par de sapatos com desconto é R$" + df.format(valorFinal));
    }
}
