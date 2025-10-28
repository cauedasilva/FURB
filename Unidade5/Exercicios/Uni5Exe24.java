import java.util.Scanner;

public class Uni5Exe24 {
    Scanner sc = new Scanner(System.in);
    double limite, pesoTotal;
    boolean continuar = true;

    public Uni5Exe24() {
        inserirValores();
    }

    private void inserirValores() {
        System.out.println("Insira o limite diário (em kg): ");
        limite = sc.nextDouble();
        while (limite > pesoTotal && continuar) {
            System.out.println("Insira o peso do peixe (em g): ");
            pesoTotal += sc.nextDouble() / 1000;
            System.out.println("O peso total pescado até o momento é de: " + pesoTotal + "kg");
            if (limite < pesoTotal) {
                System.out.println("O limite diário foi excedido!");
            } else {
                System.out.println("Deseja informar o peso de outro peixe? s(SIM) / n(NÃO)");
                char opcao = sc.next().toLowerCase().charAt(0);
                if (opcao == 'n') {
                    continuar = false;
                    break;
                }
            }   
        }
    }

    public static void main(String[] args) {
        new Uni5Exe24();
    }
}
