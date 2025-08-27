import java.util.Scanner;

public class Uni3Exe05 {
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        int frangos = lerFrangos();
        float valorTotal = calcularValorTotal(frangos);
        exibirResultado(frangos, valorTotal);
        teclado.close();
    }

    public static int lerFrangos() {
        System.out.println("Digite a quantidade de frangos: ");
        int frangos = teclado.nextInt();
        return frangos;
    }

    public static float calcularValorTotal(int frangos) {
        float valorTotal = frangos * 11;
        return valorTotal;
    }

    public static void exibirResultado(int frangos, float valorTotal) {
        System.out.printf("O gasto total para marcar %d é R$%.1f", frangos, valorTotal);
    }
    
}
