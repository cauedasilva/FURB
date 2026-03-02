import java.util.Scanner;

public class Uni4Exe11 {
    Scanner sc = new Scanner(System.in);
    int idade1, idade2, idade3;

    public Uni4Exe11() {
        informarValores();
        exibirResultado();
    }

    private void exibirResultado() {
        if (idade1 == idade2 && idade1 == idade3) {
            System.out.println("TRIGÊMEOS");
        } else if (idade1 == idade2 || idade2 == idade3 || idade1 == idade3) {
            System.out.println("GÊMEOS");
        } else {
            System.out.println("APENAS IRMÃOS");
        }

    }

    private void informarValores() {
        System.out.println("Informe a idade de Marquinhos: ");
        idade1 = sc.nextInt();
        System.out.println("Informe a idade de Zezinho: ");
        idade2 = sc.nextInt();
        System.out.println("Informe a idade de Luluzinha: ");
        idade3 = sc.nextInt();
    }

    public static void main(String[] args) {
        new Uni4Exe11();
    }
}
