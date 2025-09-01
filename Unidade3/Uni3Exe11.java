import java.util.Scanner;

public class Uni3Exe11 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        float temperatura = lerTemperatura();
        float conversao = converterTemperatura(temperatura);
        exibirResultado(conversao);
        teclado.close();
    }

    public static float lerTemperatura() {
        System.out.println("Digite a temperatura em Celsius: ");
        float temperatura = teclado.nextFloat();
        return temperatura;
    }

    public static float converterTemperatura(float temperatura) {
        float conversao = (temperatura * 9/5) + 32;
        return conversao;
    }

    public static void exibirResultado(float conversao) {
        System.out.printf("A temperatura em Fahrenheit é: %.2f", conversao);
    }
}
