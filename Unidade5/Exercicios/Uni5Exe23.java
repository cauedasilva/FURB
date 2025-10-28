import java.util.Scanner;

public class Uni5Exe23 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    int produtos;
    String nome;
    double salario, totalVendas;

    public Uni5Exe23() {
        inserirValores();
    }

    private void inserirValores() {
        while (continuar) {
            System.out.println("informe o nome do vendedor: ");
            nome = sc.next();
            System.out.println("Informe o número de produtos vendidos: ");
            produtos = sc.nextInt();
            for (int i = 1; i <= produtos; i++) {
                System.out.printf("Informe a quantidade vendida do produto %d: ", i);
                int quantidadeDeProdutos = sc.nextInt();
                System.out.printf("Informe o valor do produto %d: ", i);
                double valor = sc.nextDouble();
                calcularVendas(quantidadeDeProdutos, valor);
            }
            exibirResultado();

            System.out.println("Deseja digitar os dados de mais um vendedor? s(SIM) / n(NÃO) ");
            char opcao = sc.next().toLowerCase().charAt(0);
            if (opcao == 'n') {
                continuar = false;
                break;
            }
        }
    }

    private void calcularVendas(int quantidadeDeProdutos, double valor) {
        valor = valor * quantidadeDeProdutos;
        totalVendas += valor;
        salario = valor * 0.30;
    }

    private void exibirResultado() {
       System.out.println("Nome do vendedor: " + nome);
       System.out.println("Total de vendas: R$" + totalVendas);
       System.out.println("Salário: R$" + salario);
    }

    public static void main(String[] args) {
        new Uni5Exe23();
    }
}