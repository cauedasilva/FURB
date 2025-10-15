import java.util.Scanner;

public class Uni5Exe07 {
    Scanner sc = new Scanner(System.in);
    int num;
    float maior, menor, n;
    
    public Uni5Exe07() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        System.out.println("Digite um número: ");
        num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            System.out.println("informe o número " + i + ": ");
            n = sc.nextFloat();
            elencarNumeros(n);
        }
    }

    private void elencarNumeros(float n) {
        if (maior == 0 && menor == 0) {
            maior = n;
            menor = n;
        } else if (n > maior) {
            maior = n;
        } else if (n < menor) {
            menor = n;
        }
    }

    private void exibirResultado() {
        System.out.println("O maior número é: " + maior);
        System.out.println("O menor número é: " + menor);
    }

    public static void main(String[] args) {
        new Uni5Exe07();
    }
}
