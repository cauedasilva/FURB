import java.util.Scanner;

public class Uni4Exe14 {
    Scanner sc = new Scanner(System.in);
    int dia, mes, ano;

    public Uni4Exe14() {
        informarValores();
        exibirResultado();
    }

    private void exibirResultado() {
        if (dia > 0 && dia < 32 && mes > 0 && mes < 13 && ano > 0) {
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                System.out.println("Válido");
            } else if (mes != 2 && dia < 31) {
                System.out.println("Válido");
            } else if (mes == 2 && dia < 29) {
                System.out.println("Válido");
            } else if (dia == 29 & ano % 4 == 0 && !(ano % 100 == 0 && ano % 400 != 0)) {
                System.out.println("Válido");
            } else {
                System.out.println("Não válido");
            }
        } else {
            System.out.println("Não válido");
        }
    }
    
    private void informarValores() {
        System.out.println("Digite o dia: ");
        dia = sc.nextInt();
        System.out.println("Digite o mês: ");
        mes = sc.nextInt();
        System.out.println("Digite o ano");
        ano = sc.nextInt();
    }

    public static void main(String[] args) {
        new Uni4Exe14();
    }
}
