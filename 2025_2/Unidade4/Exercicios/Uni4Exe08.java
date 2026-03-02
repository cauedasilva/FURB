import java.util.Scanner;

public class Uni4Exe08 {
    Scanner sc = new Scanner(System.in);
    char letra;

    public Uni4Exe08() {
        informarValor();
        exibirResultado();
    }

    private void exibirResultado() {
        if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
            System.out.println("É vogal");
        } else {
            System.out.println("NÃO é vogal");
        }
    }

    private void informarValor() {
        System.out.println("Informe uma letra: ");
        letra = sc.next().toUpperCase().charAt(0);
    }

    public static void main(String[] args) {
        new Uni4Exe08();
    }

}
