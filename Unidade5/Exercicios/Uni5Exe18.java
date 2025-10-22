import java.util.Scanner;

public class Uni5Exe18 {
    Scanner sc = new Scanner(System.in);
    int numPessoas, canal;
    float totalAudiencia, canalQuatro, canalCinco, canalNove, canalDoze;
    boolean continuar = true;

    public Uni5Exe18() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        while (continuar) {
            System.out.println("Informe o número do canal: ");
            canal = sc.nextInt();
            if (canal == 4 || canal == 5 || canal == 9 || canal == 12) {
                System.out.println("Insira o número de pessoas assistindo: ");
                numPessoas = sc.nextInt();
                elencarAudiencia();
            } else if (canal == 0) {
                continuar = false;
                break;
            } else {
                System.out.println("Canal inválido");
            }
        }
    }

    private void elencarAudiencia() {
        totalAudiencia += numPessoas;
        if (canal == 4) {
            canalQuatro += numPessoas;
        } else if (canal == 5) {
            canalCinco += numPessoas;
        } else if (canal == 9) {
            canalNove += numPessoas;
        } else if (canal == 12) {
            canalDoze += numPessoas;
        }
    }

    private void exibirResultado() {
        System.out.println("Percentual de audiência do canal 4: " + totalAudiencia * canalQuatro);
        System.out.println("Percentual de audiência do canal 5: " + totalAudiencia * canalCinco);
        System.out.println("Percentual de audiência do canal 9: " + totalAudiencia * canalNove);
        System.out.println("Percentual de audiência do canal 12: " + totalAudiencia * canalDoze);
    }

    public static void main(String[] args) {
        new Uni5Exe18();
    }
}
