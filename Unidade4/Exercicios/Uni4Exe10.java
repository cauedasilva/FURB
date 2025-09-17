import java.util.Scanner;

public class Uni4Exe10 {
    Scanner sc = new Scanner(System.in);
    int idade1, idade2, idade3;

    public Uni4Exe10() {
        informarValores();
        exibirResultado();
    }
    
    private void exibirResultado() {
        if (idade1 < idade2 && idade1 < idade3) {
            System.out.println("Marquinhos é o caçula");
        } else if (idade2 < idade1 && idade2 < idade3) {
            System.out.println("Zezinho é o caçula");
        } else {
            System.out.println("Luluzinha é o caçula");
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
        new Uni4Exe10();
    }
}
