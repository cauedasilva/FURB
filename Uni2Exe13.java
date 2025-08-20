import java.util.Scanner;

public class Uni2Exe13 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a distância em KM: ");
        int distancia = teclado.nextInt();
        distancia = (60 * distancia) / 30;
        System.out.printf("O carro irá alcançar o outro em: %d minutos",  distancia);
        teclado.close();
    }
}
/* 
 * Inserido valor: 60, resultado esperado: 120 minutos
 */