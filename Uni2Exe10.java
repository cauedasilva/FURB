import java.util.Scanner;

public class Uni2Exe10 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Insira a duração do evento em segundos: ");
        int totalSegundos = teclado.nextInt();
        int horas = totalSegundos / 3600;
        int minutos = (totalSegundos % 3600) / 60;
        int segundos = totalSegundos % 60;
        System.out.printf("O tempo de duração do evento é: %02d:%02d:%02d", horas, minutos, segundos);        
        teclado.close();
    }
}
/*
 * Inserido 8400 segundos, resultado esperado: 02:20:00
 */