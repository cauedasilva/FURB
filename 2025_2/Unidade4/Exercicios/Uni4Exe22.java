import java.util.Scanner;

public class Uni4Exe22 {
    Scanner sc = new Scanner(System.in);
    int num;

    public Uni4Exe22() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Informe o número do seu curso: \n1 - Ciência da Computação \n2 - Licenciatura da Computação \n3 - Sistemas de Informação");
        num = sc.nextInt();
    }

    private void exibirResultado() {
        switch (num) {
                case 1:
                    System.out.println("Bacharel em Ciência da Computação");
                    break;
                case 2:
                    System.out.println("Licenciado em Computação");
                    break;
                case 3:
                    System.out.println("Licenciado em Computação");
                    break;
                default:
                    System.out.println("Informe um número válido");
                    break;
            }
    }


    public static void main(String[] args) {
        new Uni4Exe22();
    }
}
