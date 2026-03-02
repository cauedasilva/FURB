import java.util.Scanner;

public class Uni2Exe09 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o valor de dólares a ser trocado: ");
        float dol = teclado.nextFloat();
        float cota = 5.5f;
        System.out.printf("A atendente irá devolver: R$ %.2f ao cliente", dol * cota);
        teclado.close();
    }
}
/*
 * Inserido valor: 1500, resultado esperado: 8250,00
 */