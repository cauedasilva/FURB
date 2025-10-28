import java.util.Scanner;

public class Uni5Exe27 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;

    public Uni5Exe27() {
        inserirValores();
        exibirResultado();
    }

    private void inserirValores() {
        while (continuar) {
            System.out.println("Informe o dia do mês de Abril: ");
            dia =  sc.nextInt();
            if (dia < 0 || dia > 30) {
                System.out.println("Dia inválido");
            } else {
                System.out.println("Peças produzidas no turno da manhã: ");
                pecasMatutino = sc.nextInt();
                System.out.println("Peças produzidas no turno da tarde: ");
                pecasVespertino = sc.nextInt();
                exibirResultado();
            }
            
            System.out.println("Deseja informar um novo funcionário? s(SIM) / n(NÃO)");
            char opcao = sc.next().toLowerCase().charAt(0);
            if (opcao == 'n') {
                continuar = false;
                break;
            }
        }
    }

    private void exibirResultado() {
        pecasTotal = pecasMatutino + pecasVespertino;
        if (dia <= 15) {
            if (pecasMatutino > 30 && pecasVespertino > 30 && pecasTotal > 100) {
                valor = pecasTotal * 0.80;
            } else {
                valor = pecasTotal * 050;
            }
        } else if (dia > 15) {
            valor = pecasMatutino * 0.40 + pecasVespertino * 0.30;
        }


    }

    public static void main(String[] args) {
        new Uni5Exe27();
    }
}
