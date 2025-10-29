import java.util.Scanner;

public class Uni5Exe27 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    int dia, pecasMatutino, pecasVespertino, pecasTotal, contMatutino, contVespertino, maior, diaMaior, pecasMatutinoTotal, pecasVespertinoTotal;
    double valor;

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
                calcularValor();

                System.out.println("Deseja informar um novo funcionário? s(SIM) / n(NÃO)");
                char opcao = sc.next().toLowerCase().charAt(0);
                if (opcao == 'n') {
                    continuar = false;
                    break;
                }
            }
        }
    }

    private void calcularValor() {
        pecasTotal = pecasMatutino + pecasVespertino;
        if (dia <= 15) {
            if (pecasMatutino > 30 && pecasVespertino > 30 && pecasTotal > 100) {
                valor = pecasTotal * 0.80;
            } else {
                valor = pecasTotal * 0.50;
            }
        } else if (dia > 15) {
            valor = pecasMatutino * 0.40 + pecasVespertino * 0.30;
        }

        if (pecasTotal > maior) {
            maior = pecasTotal;
            diaMaior = dia;
        } else if (maior == 0) {
            maior = pecasTotal;
            diaMaior = dia;
        }

        if (pecasMatutino > pecasVespertino) {
            contMatutino++;
            pecasMatutinoTotal += pecasMatutino;
        } else if (pecasVespertino > pecasMatutino) {
            contVespertino++;
            pecasVespertinoTotal += pecasVespertino;
        } 

        System.out.println("Valor a ser pago: R$ " + valor);
    }

    private void exibirResultado() {
        System.out.println("Dia com maior produção: " + diaMaior + " com " + maior + " peças.");
        if (contMatutino > contVespertino) {
            System.out.println("Maior produção ocorreu no turno da manhã: " + pecasMatutinoTotal + " peças." );
        } else if (contVespertino > contMatutino) {
            System.out.println("Maior produção ocorreu no turno da tarde: " + pecasVespertinoTotal + " peças." );
        } else {
            System.out.println("Produção igual nos dois turnos." );
        }
    }

    public static void main(String[] args) {
        new Uni5Exe27();
    }
}
