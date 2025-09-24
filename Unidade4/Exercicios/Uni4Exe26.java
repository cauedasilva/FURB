import java.util.Scanner;

public class Uni4Exe26 {
    Scanner sc = new Scanner(System.in);
    char opcao;

    public Uni4Exe26() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Selecione uma das opções: \nT: calcular a área de um triângulo de base b e altura h \nQ: calcular a área de um quadrado de lado l \nR: calcular a área de um retângulo de base b e altura h \nC: calcular a área de um círculo de raio r");
        opcao =  sc.next().toUpperCase().charAt(0);
    }

    private void calcularTriangulo() {
        System.out.println("Digite a base do triângulo: ");
        float b = sc.nextFloat();
        System.out.println("Digite a altura do triângulo: ");
        float h = sc.nextFloat();
        System.out.println((b * h) / 2);
    }

    private void calcularQuadrado() {
        System.out.println("Digite o lado do quadrado: ");
        float l = sc.nextFloat();
        System.out.println(l * l);
    }

    private void calcularRetangulo() {
        System.out.println("Digite a base do retângulo: ");
        float b = sc.nextFloat();
        System.out.println("Digite a altura do retângulo: ");
        float h = sc.nextFloat();
        System.out.println(b * h);
    }

    private void calcularCirculo() {
        System.out.println("Digite o raio do círculo: ");
        float r = sc.nextFloat();
        System.out.println(Math.PI * Math.pow(r, 2));
    }

    private void exibirResultado() {
        switch (opcao) {
            case 'T':
                calcularTriangulo();
                break;
            case 'Q':
                calcularQuadrado();
                break;
            case 'R':
                calcularRetangulo();
                break;
            case 'C':
                calcularCirculo();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }


    public static void main(String[] args) {
        new Uni4Exe26();
    }
}
