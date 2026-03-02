import java.util.Scanner;

public class Uni5Exe30 {
    Scanner sc = new Scanner(System.in);
    int n, k, mInicial = 25, mFinal, elemento, somaDentro, somaFora;
    String elementosDentro = "", elementosFora = "", elementos = "";
    boolean continuar = true;

    public Uni5Exe30() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        System.out.println("Informe o número de elementos:");
        n = sc.nextInt();
        elemento = n;
        System.out.println("Informe o número de decremento:");
        k = sc.nextInt();

        while (elemento > 0) {
            elementos += elemento + ", ";
            if (mFinal + elemento <= mInicial) {
                mFinal += elemento;
                elementosDentro += elemento + ", ";
                somaDentro += elemento;
                System.out.println("Memória Final atual: " + mFinal);
            } else {
                elementosFora += elemento + ", ";
                somaFora += elemento;
            }
            elemento -= k;
            System.out.println("Elemento atual: " + elemento);
        }
    }

    private void exibirResultado() {
        System.out.println("Elementos a serem colocados na mochila: " + elementos);
        System.out.println("Elementos dentro da mochila: " + elementosDentro);
        System.out.println("Soma dos elementos dentro da mochila: " + somaDentro);
        System.out.println("Elementos fora da mochila: " + elementosFora);
        System.out.println("Soma dos elementos fora da mochila: " + somaFora);
    }

    public static void main(String[] args) {
        new Uni5Exe30();
    }
}
