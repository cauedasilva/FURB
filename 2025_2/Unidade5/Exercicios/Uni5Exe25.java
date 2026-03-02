import java.util.Scanner;

public class Uni5Exe25 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    int pontosE, pontosD, maior, diferenca;

    public Uni5Exe25() {
        inserirValores();
    }

    private void inserirValores() {
        while (continuar) {
            System.out.println("Informe para quem foi o ponto nesta rodada: D ou E");
            char opcao = sc.next().toLowerCase().charAt(0);
            switch (opcao) {
                case 'd':
                    pontosD++;
                    break;
                case 'e':   
                    pontosE++;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            System.out.printf("Os pontos nesta rodada são: D(%d) vs E(%d) \n", pontosD, pontosE);
            if (pontosD >= 21 || pontosE >= 21) {
                calcularDiferenca();
                if (diferenca >= 2 && maior == pontosE) {
                    System.out.println("O vencedor foi o lado esquerdo!");
                    continuar = false;
                    break;
                } else if (diferenca >= 2 && maior == pontosD) {
                    System.out.println("O vencedor foi o lado direito!");
                    continuar = false;
                    break;                    
                }
            }
        }
    }

    private void calcularDiferenca() {
        if (pontosD > pontosE) {
            maior = pontosD;
            diferenca = pontosD - pontosE;
        } else if (pontosE > pontosD) {
            maior = pontosE;
            diferenca = pontosE - pontosD;
        }
    }

    public static void main(String[] args) {
        new Uni5Exe25();
    }
}
