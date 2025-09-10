import java.util.Scanner;

public class MediaAluno {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        float nota1 = lerNota();
        float nota2 = lerNota();
        float nota3 = lerNota();
        float media = calcularMedia(nota1, nota2, nota3);
        float frequencia = lerFrequencia();
        String resultado;
        if (decidirAprovado(media) && decidirFrequencia(frequencia)) {
            resultado = "A média é: %.2f\ncom frequência de: %.0f\nAprovado!";
        } else {
            resultado = "A média é: %.2f\ncom frequência de: %.0f\nReprovado";
        }
        System.out.printf(resultado, media, frequencia);
        teclado.close();
    }

    public static float lerNota() {
        return teclado.nextFloat();
    }

    public static float calcularMedia(float nota1, float nota2, float nota3) {
        return (nota1 + nota2 + nota3) / 3;
    }

    public static boolean decidirAprovado(float media) {
        if (media >= 6) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean decidirFrequencia(float frequencia) {
        if (frequencia >= 75) {
          return true;
        } else {
            return false;
        }
    }

    public static float lerFrequencia() {
        System.out.println("Digite a frequência: ");
        return teclado.nextFloat();
    }
}
