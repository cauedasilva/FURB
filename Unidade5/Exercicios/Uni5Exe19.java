import java.util.Scanner;

public class Uni5Exe19 {
    Scanner sc = new Scanner(System.in);
    float valorCompra, valorFinal, valorTotal;
    boolean continuar = true;

    public Uni5Exe19() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        while (continuar) {
            System.out.println("Informe o valor da compra: ");
            valorCompra = sc.nextFloat();

            if (valorCompra == 0) {
                continuar = false;
                break;
            } else {
                calcularDesconto();
            }
        }
    }

    private void calcularDesconto() {
        if (valorCompra > 500) {
            valorFinal = valorCompra * 0.80f;
        } else if (valorCompra <= 500) {
            valorFinal = valorCompra * 0.85f;
        }
        valorTotal += valorFinal;

        System.out.println("O valor a pagar é: R$" + valorFinal);
    }

    private void exibirResultado() {
        System.out.println("O valor total recebido das compras é: R$" + valorTotal);
    }

    public static void main(String[] args) {
        new Uni5Exe19();
    }
}
