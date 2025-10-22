import java.util.Scanner;

public class Uni5Exe15 {
    Scanner sc = new Scanner(System.in);
    String nome;
    boolean continuar = true;
    float nota1, nota2, media;

    public Uni5Exe15() {
        inserirValor();
    }

    private void inserirValor() {
        while (continuar) {
            System.out.println("Nome do aluno: ");
            nome = sc.next();
            if (nome.equals("fim")) {
                continuar = false;
                break;
            }
            System.out.println("Informe a primeira nota: ");
            nota1 = sc.nextFloat();
            System.out.println("Informe a segunda nota: ");
            nota2 = sc.nextFloat();

            exibirResultado();
        }
    }

    private void exibirResultado() {
        media = (nota1 + nota2) / 2;
        System.out.println("A média do aluno " + nome + " é: " + media);
    }

    public static void main(String[] args) {
        new Uni5Exe15();
    }
}
