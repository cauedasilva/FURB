import java.util.Scanner;

public class Uni3Exe01 {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        int largura = lerLargura();
        int comprimento = lerComprimento();
        int resultado = calcularArea(largura, comprimento);
        exibirResultado(resultado);
        teclado.close();
    }

    public static int lerLargura() {
        System.out.println("Escreva a largura do terreno: ");
        int largura = teclado.nextInt();
        return largura;
    }

    public static int lerComprimento() {
        System.out.println("Escreva o comprimento do terreno: ");
        int comprimento = teclado.nextInt();
        return comprimento;
    }

    public static void exibirResultado(int resultado) {
        System.out.println("A área do terreno é: " + resultado + "m²");
    }
    
    public static int calcularArea(int i, int j) {
        return i * j;
    }
}
