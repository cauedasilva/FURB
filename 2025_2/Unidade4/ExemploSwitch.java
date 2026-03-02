import java.util.Scanner;

public class ExemploSwitch {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite um dígito de 0 à 6, para o dia da semana: ");
        int diaDaSemana = teclado.nextInt();
        String nomeDoDia;
        switch (diaDaSemana) {
            case 0:
                nomeDoDia = "Domingo";
                break;
            case 1:
                nomeDoDia = "Segunda-feira";
                break;
            case 2:
                nomeDoDia = "Terça-feira";
                break;
            case 3:
                nomeDoDia = "Quarta-feira";
                break;
            case 4:
                nomeDoDia = "Quinta-feira";
                break;
            case 5:
                nomeDoDia = "Sexta-feira";
                break;
            case 6:
                nomeDoDia = "Sábado";
                break;
            default:
            nomeDoDia = "Dia inválido";
                break;
        }
        System.out.println("O dia da semana é: " + nomeDoDia);
        teclado.close();
    }
}
