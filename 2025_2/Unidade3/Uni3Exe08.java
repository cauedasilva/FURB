import java.util.Scanner;

public class Uni3Exe08 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        float dolares = lerValores("Valor em dólares recebido pelo cliente:");
        float cotacao = lerValores("Cotação do dólar hoje:");
        float cambio = calcularCambio(dolares, cotacao);
        exibirResultado(cambio);
        teclado.close();
    }

    public static float lerValores(String mensagem) {
        System.out.println(mensagem);
        float valor = teclado.nextFloat();
        return valor;
    }

    public static float calcularCambio(float dolares, float cotacao) {
        float cambio = dolares * cotacao;
        return cambio;
    }

    public static void exibirResultado(float cambio) {
        System.out.printf("O atendente deve devolver R$%.2f para o cliente.", cambio);
    }
}
