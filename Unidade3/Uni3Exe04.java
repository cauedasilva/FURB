import java.util.Scanner;

public class Uni3Exe04 {
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        float nota1 = lerNota("primeira");
        float nota2 = lerNota("segunda"); 
        float nota3 = lerNota("terceira");
        float media = calcularMedia(nota1, nota2, nota3);
        exibirResultado(media);
        teclado.close();
    }
    public static float lerNota(String ordem) {
        System.out.println("Digite a " + ordem + " nota: ");
        float nota = teclado.nextFloat();
        return nota;
    }
    public static float calcularMedia(float nota1, float nota2, float nota3) {
        return (nota1 * 5 + nota2 * 3 + nota3 * 2) / 10;
    }

    public static void exibirResultado(float media) {
        System.out.printf("A média final é: %.2f", media);
    }
}
