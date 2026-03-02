import java.util.Scanner;

public class Uni5Exe34 {
    Scanner sc = new Scanner(System.in);
    int opcao, contadorContas = 0;
    double total;
    boolean continuar = true;

    public Uni5Exe34() {
        inserirValor();
    }

    private void inserirValor() {
        while (continuar) {
            System.out.println("(1) Encerrar a conta de um hóspede");
            System.out.println("(2) Verificar o número de contas encerradas");
            System.out.println("(3) Sair");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    calculcarConta();
                    break;
                case 2:
                    System.out.println("O número de contas encerradas é: " + contadorContas);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        
    }

    private void calculcarConta() {
        System.out.println("Informe o nome do hóspede: ");
        String nomeHospede = sc.next();
        System.out.println("Informe o número de diárias: ");
        int diarias = sc.nextInt();
        
        if (diarias < 15) {
            total = diarias * 7.50;
        } else if (diarias == 15) {
            total = diarias * 6.50;
        } else {
            total = diarias * 5.00;
        }

        System.out.printf("A conta do hóspede %s é: R$ %.2f%n", nomeHospede, total);
        contadorContas++;
    }

    public static void main(String[] args) {
        new Uni5Exe34();
    }
}
