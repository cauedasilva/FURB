import java.util.Scanner;

public class Uni5Exe08 {
    Scanner sc = new Scanner(System.in);
    int num;
    float menor, n, somaPositivos, numPositivos;
    
    public Uni5Exe08() {
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
        if (n < 0) {
            if (menor == 0) {
                 menor = n;
            } else if (n < menor) {
                menor = n;
                }
        } else {
            numPositivos++;
            somaPositivos += n;
        }
    }

    private void exibirResultado() {
        if (menor < 0) {
            System.out.println("O menor número negativo é: " + menor);
        } else {
            System.out.println("Não foram informados números negativos.");
        }
        if (numPositivos > 0) {
            System.out.println("A média dos números positivos é: " + (somaPositivos / numPositivos));
        } else {
            System.out.println("Não foram informados números positivos.");
        }
    }

    public static void main(String[] args) {
        new Uni5Exe08();
    }
}
