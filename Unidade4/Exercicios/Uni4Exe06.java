import java.util.Scanner;

public class Uni4Exe06 {
    Scanner sc = new Scanner(System.in);
    char genero;

    public Uni4Exe06() {
        informarValor();
        exibirResultado();
    }

    private void exibirResultado() {
        if (genero == 'M') {
            System.out.println("Masculino");
        } else if (genero == 'F') {
            System.out.println("Feminino");
        } else if (genero == 'I') {
            System.out.println("Não informado");
        } else {
            System.out.println("Entrada incorreta");
        }
    }

    private void informarValor() {
        System.out.println("Digite somente um caractere de gênero: \nM - Masculino \nF - Feminino \nI - Não informado");
        genero = sc.next().toUpperCase().charAt(0);
    }

    public static void main(String[] args) {
        new Uni4Exe06();
    }

}
