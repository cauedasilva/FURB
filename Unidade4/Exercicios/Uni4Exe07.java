import java.util.Scanner;

public class Uni4Exe07 {
    Scanner sc = new Scanner(System.in);
    double peso, valorPagar;

    public Uni4Exe07() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Digite o peso da carta em gramas: ");
        peso = sc.nextDouble();
    }

    private void exibirResultado() {
        double pesoExcedido, quantidadeAdicional;
        if (peso <= 50) {
            valorPagar = 0.45;
        } else {
            pesoExcedido = peso - 50; // 50
            quantidadeAdicional = (pesoExcedido / 20) + 1; 
            valorPagar = 0.45f + (0.45f * quantidadeAdicional);
        }
        System.out.println("Custo do selo: " + valorPagar);
    }

    public static void main(String[] args) {
        new Uni4Exe07();
    }
}
