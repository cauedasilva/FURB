import java.util.Scanner;

public class Uni5Exe33 {
    Scanner sc = new Scanner(System.in);
    int num, votosUm, votosDois, votosTres, votosQuatro, votosNulo, votosBranco, totalVotos, totalBrancosNulos;
    double percentualBrancosNulos;

    public Uni5Exe33() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        do {
            System.out.println("Informe o número do voto: (0 para encerrar) ");
            num = sc.nextInt();
            if (num == 1 || num == 2 || num == 3 || num == 4 || num == 5 || num == 6) {
                elencarVotos();
            } else {
                System.out.println("Opção incorreta");
            }
        } while (num != 0);
        
    }

    private void elencarVotos() {
        switch (num) {
            case 1:
                votosUm++;
                break;
            case 2:
                votosDois++;
                break;
            case 3:
                votosTres++;
                break;
            case 4:
                votosQuatro++;
                break;
            case 5:
                votosNulo++;
                break;
            case 6:
                votosBranco++;
                break;
        }

        totalVotos++;
        totalBrancosNulos = votosNulo + votosBranco;
        percentualBrancosNulos = (double) (totalBrancosNulos * 100.0) / (double) totalVotos;
    }

    private void exibirResultado() {
        System.out.println("Total de votos para o candidato 1: " + votosUm);
        System.out.println("Total de votos para o candidato 2: " + votosDois);
        System.out.println("Total de votos para o candidato 3: " + votosTres);
        System.out.println("Total de votos para o candidato 4: " + votosQuatro);
        System.out.println("Total de votos nulos: " + votosNulo);
        System.out.println("Total de votos em branco: " + votosBranco);
        System.out.println("Percentual de votos brancos e nulos: " + percentualBrancosNulos + "%");
    }

    public static void main(String[] args) {
        new Uni5Exe33();
    }
}
