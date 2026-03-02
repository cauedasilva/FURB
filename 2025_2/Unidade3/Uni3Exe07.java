import java.util.Scanner;

public class Uni3Exe07 {    
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int lata350ml = lerProduto("350ml");
        int garrafa600ml = lerProduto("600ml");
        int garrafa2litros = lerProduto("2L");
        float total = calcularTotal(lata350ml, garrafa600ml, garrafa2litros);
        exibirResultado(total);
        teclado.close();
    }

    public static int lerProduto(String produto) {
        System.out.println("Quantidade de " + produto + ": ");
        int quantidade = teclado.nextInt();
        return quantidade;
    }

    public static float calcularTotal(int lata350ml, int garrafa600ml, int garrafa2litros) {
        float total = (lata350ml * 0.35f) + (garrafa600ml * 0.6f) + (garrafa2litros * 2);
        return total;
    }

    public static void exibirResultado(float total) {
        System.out.printf("O cliente comprou ao total %.2f litros.", total);
    }

}
