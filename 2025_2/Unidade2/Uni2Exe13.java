import java.util.Scanner;

public class Uni2Exe13 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite a distância em KM: ");
        int distancia = teclado.nextInt();
        int minutos = (60 * distancia) / 30;
        System.out.printf("O carro Y irá tomar a distância de %dKM do carro X em: %d minutos",  distancia, minutos);
        teclado.close();
    }
}
/* 
 * Inserido valor: 60, resultado esperado: 120 minutos
 */