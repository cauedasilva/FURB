import java.util.Scanner;

public class DiaDaSemana {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o dia semana: ");
        String nomeDoDia = teclado.nextLine().toUpperCase();
        int diaDaSemana;
        switch (nomeDoDia) {
            case "DOMINGO":
                diaDaSemana = 0;
                break;
            case "SEGUNDA":
                diaDaSemana = 1;
                break;
            case "TERCA":
                diaDaSemana = 2;
                break;
            case "QUARTA":
                diaDaSemana = 3;
                break;
            case "QUINTA":
                diaDaSemana = 4;
                break;
            case "SEXTA":
                diaDaSemana = 5;
                break;
            case "SABADO":
                diaDaSemana = 6;
                break;
            default:
                diaDaSemana = 7;
                break;
        }
        if (diaDaSemana <= 6) {
            System.out.println("O dígito correspondente ao dia da semana é: " + diaDaSemana);
        } else {
            System.out.println("O dia da semana digitado é inválido");
        }
        
        teclado.close();
    }
}
