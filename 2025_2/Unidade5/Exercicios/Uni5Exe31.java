import java.util.Scanner;

public class Uni5Exe31 {
    Scanner sc = new Scanner(System.in);
    int num, divisor = 2;

    public Uni5Exe31() {
        inserirValor();
    }

    private void inserirValor() {
        System.out.println("Informe um número inteiro positivo: ");
        num = sc.nextInt();
        System.out.println("Decomposição de " + num + ": ");

        while (divisor <= num) {
            while (num % divisor == 0) {
                System.out.print(num + " ");
                System.out.print(divisor);
                System.out.println();
                num /= divisor;
            }
            divisor++;
        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        new Uni5Exe31();
    }
}
