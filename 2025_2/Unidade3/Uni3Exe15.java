import java.util.Scanner;

public class Uni3Exe15 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int valor = lerValor();
        int centenas = calcularCentenas(valor);
        int dezenas = calcularDezenas(valor);
        int unidades = calcularUnidades(valor);
        exibirResultado(centenas, dezenas, unidades);
        teclado.close();
    }

    public static int lerValor() {
        System.out.println("Digite um valor entre 0 e 999: ");
        int valor = teclado.nextInt();
        return valor;
    }

    public static int calcularCentenas(int valor) {
        int centenas = valor / 100;
        return centenas;
    }

    public static int calcularDezenas(int valor) {
        int dezenas = (valor % 100) / 10;
        return dezenas;
    }

    public static int calcularUnidades(int valor) {
        int unidades = valor % 10;
        return unidades;
    }

    public static void exibirResultado(int centenas, int dezenas, int unidades) {
        System.out.printf("%d centena(s) %d dezena(s) %d unidade(s)", centenas, dezenas, unidades);
    }
}
