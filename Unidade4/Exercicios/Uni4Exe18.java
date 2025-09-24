import java.util.Scanner;

public class Uni4Exe18 {
    Scanner sc = new Scanner(System.in);
    double valor;
    int diaPagamento, diaVencimento;

    public Uni4Exe18() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Insira o dia do vencimento: ");
        diaVencimento = sc.nextInt();
        System.out.println("Insira o dia do pagamento: ");
        diaPagamento = sc.nextInt();
        System.out.println("Insira o valor da prestação: ");
        valor = sc.nextDouble();
    }

    private void exibirResultado() {
        int atraso = diaPagamento - diaVencimento;
        if (diaPagamento <= diaVencimento) {
            valor = valor * 0.90;
            System.out.println("O pagamento está em dia. O valor da prestação = R$" + valor);
        } else if (atraso <= 5) {
            System.out.println("O valor da prestação = R$" + valor);
        } else if (atraso > 5) {
            System.out.println("O pagamento está atrasado. Multa de 2% por dia de atraso. Valor da prestação = R$" + (valor + valor * (((double) atraso / 100) * 2)));
        }
    }


    public static void main(String[] args) {
        new Uni4Exe18();
    }
}
