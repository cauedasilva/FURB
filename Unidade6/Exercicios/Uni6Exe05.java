import java.util.Scanner;

public class Uni6Exe05 {
    Scanner sc = new Scanner(System.in);
    char respostasH[] = new char[5];
    char respostasM[] = new char[5];

    public Uni6Exe05() {
        inserirValores();
        exibirResultado();
    }

    public void inserirValores() {
        System.out.println("Responda com SIM(s), NÃO(n) ou IND(i) em ordem o questionário:");
        System.out.println("Gosta de música sertaneja?");
        System.out.println("Gosta de futebol?");
        System.out.println("Gosta de seriados?");
        System.out.println("Gosta de redes sociais?");
        System.out.println("Gosta da Oktoberfest?");
        System.out.println("Respostas do rapaz:");
        for (int i = 0; i < respostasH.length; i++) {
            System.out.print("Pergunta " + (i + 1) + ":");
            respostasH[i] = sc.next().toLowerCase().charAt(0);
        }
        System.out.println("Respostas da moça:");
        for (int i = 0; i < respostasM.length; i++) {
            System.out.print("Pergunta " + (i + 1) + ":");
            respostasM[i] = sc.next().toLowerCase().charAt(0);
        }
    }

    public void exibirResultado() {
        int afinidade = 0;

        for (int i = 0; i < respostasH.length; i++) {
            if (respostasH[i] == respostasM[i]) {
                afinidade += 3;
            } else if (respostasH[i] == 'i' && respostasM[i] == 's' || respostasH[i] == 'i' && respostasM[i] == 'n' || respostasM[i] == 'i' && respostasH[i] == 's' || respostasM[i] == 'i' && respostasH[i] == 'n') {
                afinidade++;
            } else if (respostasH[i] == 's' && respostasM[i] == 'n' || respostasM[i] == 's' && respostasH[i] == 'n') {
                afinidade -= 2;
            }
        }

        System.out.println("Resultado do teste:");
        if (afinidade == 15) {
            System.out.println("Casem!");
        } else if (afinidade >= 10 && afinidade < 15) {
            System.out.println("Vocês têm muita coisa em comum!");
        } else if (afinidade >= 5 && afinidade < 10) {
            System.out.println("Talvez não dê certo :(");
        } else if (afinidade >= 0 && afinidade < 5) {
            System.out.println("Vale um encontro.");
        } else if (afinidade < 0 && afinidade > -10) {
            System.out.println("Melhor não perder tempo");
        } else if (afinidade <= -10) {
            System.out.println("Vocês se odeiam!");
        }
    }

    public static void main(String[] args) {
        new Uni6Exe05();
    }
}
