import java.util.Scanner;

public class Uni5Exe21 {
    Scanner sc = new Scanner(System.in);
    double chico = 1.5, ze = 1.1;
    int anos;

    public Uni5Exe21() {
        exibirResultado();
    }

    private void exibirResultado() {
        while (chico > ze) {
            ze += 0.03;
            chico += 0.02;
            anos += 1;
        }

        System.out.println("A altura de Chico é: " + chico + "m");
        System.out.println("A altura de Zé é: " + ze + "m");
        System.out.println("Foram necessários " + anos + " anos para Zé ultrapassar Chico em altura");
    }

    public static void main(String[] args) {
        new Uni5Exe21();
    }
}