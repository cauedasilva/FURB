import java.util.Scanner;

public class Uni5Exe28 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    int cod, vencedor;
    float codUm, codDois, codTres, codQuatro, totalVotos, maiorVotos;


    public Uni5Exe28() {
        inserirValores();
        exibirResultado();
    }

   private void inserirValores() {
        while (continuar) {
            System.out.println("Informe o código do conjunto: ");
            cod = sc.nextInt();
            if (cod == 1 || cod == 2 || cod == 3 || cod == 4) {
                elencarVotos();
                System.out.println("Deseja informar um novo voto? s(SIM) / n(NÃO)");
                char opcao = sc.next().toLowerCase().charAt(0);
                if (opcao == 'n') {
                    continuar = false;
                    break;
                }
            } else {
                System.out.println("código inválido");
            }
        }
    }

    private void elencarVotos() {
        totalVotos++;

        if (cod == 1) {
            codUm++;
        } else if (cod == 2) {
            codDois++;
        } else if (cod == 3) {
            codTres++;
        } else if (cod == 4) {
            codQuatro++;
        }

        if (codUm > maiorVotos) {
            maiorVotos = codUm;
            vencedor = 1;
        } else if (codDois > maiorVotos) {
            maiorVotos = codDois;
            vencedor = 2;
        } else if (codTres > maiorVotos) {
            maiorVotos = codTres;
            vencedor = 3;
        } else if (codQuatro > maiorVotos) {
            maiorVotos = codQuatro;
            vencedor = 4;
        }
    }

    private void exibirResultado() {
        System.out.println("Percentual de votos do conjunto 1: " + (codUm / totalVotos) * 100 + "% com " + codUm + " votos.");
        System.out.println("Percentual de votos do conjunto 2: " + (codDois / totalVotos) * 100 + "% com " + codDois + " votos.");
        System.out.println("Percentual de votos do conjunto 3: " + (codTres / totalVotos) * 100 + "% com " + codTres + " votos.");
        System.out.println("Percentual de votos do conjunto 4: " + (codQuatro / totalVotos) * 100 + "% com " + codQuatro + " votos.");
        System.out.println("O grupo vencedor foi o conjunto " + vencedor + " com " + maiorVotos + " votos.");
    }

    public static void main(String[] args) {
        new Uni5Exe28();
    }
}
