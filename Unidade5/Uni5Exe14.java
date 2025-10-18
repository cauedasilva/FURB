import java.util.Scanner;

public class Uni5Exe14 {
    Scanner sc = new Scanner(System.in);
    float pv, pc;
    int lucroMenor10, lucroEntre10e20, lucroMaior20, totalPv, totalPc, lucroTotal;

    public Uni5Exe14() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        for (int i = 1; i <= 4; i++) {
            System.out.println("Insira o preço de compra da mercadoria " + i + ": ");
            pc = sc.nextFloat();
            System.out.println("Insira o preço de venda da mercadoria " + i + ": ");
            pv = sc.nextFloat();

            calcularResultado();
        }
    }

    private void calcularResultado() {
        float desconto = (pv - pc) / pc * 100;
        if (desconto < 10) {
            lucroMenor10++;
        } else if (desconto >= 10 && desconto <= 20) {
            lucroEntre10e20++;
        } else {
            lucroMaior20++;
        }

        totalPc += pc;
        totalPv += pv;
    }

    private void exibirResultado() {
        lucroTotal = totalPv - totalPc;
        System.out.println("Número de mercadorias com lucro menor que 10%: " + lucroMenor10);
        System.out.println("Número de mercadorias com lucro entre 10% e 20%: " + lucroEntre10e20);
        System.out.println("Número de mercadorias com lucro maior que 20%: " + lucroMaior20);
        System.out.println("Total gasto na compra das mercadorias: " + totalPc);
        System.out.println("Total obtido com a venda das mercadorias: " + totalPv);
        System.out.println("Lucro total obtido: " + lucroTotal);
    }

    public static void main(String[] args) {
        new Uni5Exe14();
    }
}
