import java.util.Scanner;

public class Uni3Exe09 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        float raio = lerMedida("raio");
        float altura = lerMedida("altura");
        float volume = calcularVolume(raio, altura);
        exibirResultado(volume);
        teclado.close();
    }

    public static float lerMedida(String medida) {
        System.out.println("Digite o valor do " + medida + ": ");
        float valor = teclado.nextFloat();
        return valor;
    }
    public static float calcularVolume(float raio, float altura) {
        float volume = (float) (Math.PI * Math.pow(raio, 2) * altura);
        return volume;
    }
    
    public static void exibirResultado(float volume) {
        System.out.printf("O volume da lata de óleo é: %.2f", volume);
    }
}
