import java.util.Scanner;

public class Uni3Exe16 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int valorCompra = lerValor();
        int valorPago = lerValor();
        int troco = calcularTroco(valorCompra, valorPago);
        int cedulas100 = calcularCentenas(troco);
        troco %= 100;
        int cedulas10 = calcularDezenas(troco);
        troco %= 10;
        int cedulas1 = calcularUnidades(troco);
        int notas = calcularNotas(cedulas100, cedulas10, cedulas1);
        exibirResultado(cedulas100, cedulas10, cedulas1, notas);
        teclado.close();
    }

    public static int lerValor() {
        System.out.println("Digite o valor: ");
        int valor = teclado.nextInt();
        return valor;
    }

    public static int calcularTroco(int valorCompra, int valorPago) {
        int troco = valorPago - valorCompra;
        return troco;
    }

    public static int calcularCentenas(int troco) {
        int centenas = troco / 100;
        return centenas;
    }

    public static int calcularDezenas(int troco) {
        int dezenas = (troco % 100) / 10;
        return dezenas;
    }

    public static int calcularUnidades(int troco) {
        int unidades = troco % 10;
        return unidades;
    }

    public static int calcularNotas(int centenas, int dezenas, int unidades) {
        int notas = centenas + dezenas + unidades;
        return notas;
    }

    public static void exibirResultado(int centenas, int dezenas, int unidades, int notas) {
        System.out.printf("O número mínimo de notas de troco é: %d \n", notas);
        System.out.printf("Quantidade de notas de 100 necessárias é: %d \n", centenas);
        System.out.printf("Quantidade de notas de 10 necessárias é: %d \n", dezenas);    
        System.out.printf("Quantidade de notas de 1 necessárias é: %d \n", unidades);
    }

}   
