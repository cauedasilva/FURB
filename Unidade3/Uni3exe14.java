import java.util.Scanner;

public class Uni3exe14 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        float distancia = lerMedida("Distância");
        float tempo = lerMedida("Tempo");
        float velocidade = calcularVelocidade(distancia, tempo);
        float combustivelGasto = calcularCombustivel(distancia);
        exibirResultado(velocidade, combustivelGasto);
        teclado.close();
    }

    public static float lerMedida(String medida) {
        System.out.println(medida + ": ");
        float valor = teclado.nextFloat();
        return valor;
    }

    public static float calcularVelocidade(float distancia, float tempo) {
        float velocidade = distancia / tempo;
        return velocidade;
    }

    public static float calcularCombustivel(float distancia) {
        float valor = distancia / 12;
        return valor;
    }

    public static void exibirResultado(float velocidade, float combustivelGasto) {
        System.out.printf("A velocidade média foi de %.2f km/h e a quantidade de combustível usado foi %.2f litros", velocidade, combustivelGasto);
    }

}
