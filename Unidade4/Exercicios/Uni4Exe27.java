import java.util.Scanner;

public class Uni4Exe27 {
    Scanner sc = new Scanner(System.in);
    int horaChegada, minSaida, horaSaida, minChegada, horasEstacionado, minutosEstacionado, minutosTotais;

    public Uni4Exe27() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Informe a hora de chegada: ");
        horaChegada = sc.nextInt();
        System.out.println("Informe os minutos de chegada: ");
        minChegada = sc.nextInt();
        System.out.println("Informe a hora de saída: ");
        horaSaida = sc.nextInt();
        System.out.println("Informe os minutos de saída: ");
        minSaida = sc.nextInt();
    }

    private void exibirResultado() {
        if (horaChegada < 0 || horaChegada > 23 || horaSaida < 0 || horaSaida > 23 || minChegada < 0 || minChegada > 59 || minSaida < 0 || minSaida > 59) {
            System.out.println("Horário inválido");
        }

        int minutosChegadaTotal = horaChegada * 60 + minChegada;
        int minutosSaidaTotal = horaSaida * 60 + minSaida;

        if (minutosSaidaTotal < minutosChegadaTotal) {
            System.out.println("Horário inválido");
        }

        minutosTotais = minutosSaidaTotal - minutosChegadaTotal;
        horasEstacionado = minutosTotais / 60;
        minutosEstacionado = minutosTotais % 60;

        float valorPrimeirasHoras = 5.0f;
        float valorTerceiraHora = 7.5f;
        float ValorDemaisHoras = 10.0f;
        float horasParaCobrar, valorTotal;

        if (minutosTotais < 30) {
            horasParaCobrar = 1;
        } else if (minutosEstacionado <= 29) {
            horasParaCobrar = horasEstacionado;
        } else {
            horasParaCobrar = horasEstacionado + 1;
        }

        if (horasParaCobrar <= 2) {
            valorTotal = valorPrimeirasHoras * horasParaCobrar;
        } else if (horasParaCobrar == 3) {
            valorTotal = (valorPrimeirasHoras * 2) + valorTerceiraHora;
        } else if (horasParaCobrar == 4) {
            valorTotal = (valorPrimeirasHoras * 2) + (valorTerceiraHora *2);
        } else {
            valorTotal = (valorPrimeirasHoras * 2) + (valorTerceiraHora *2) + (ValorDemaisHoras * (horasParaCobrar - 4));
        } 

        System.out.printf("O valor a ser pago é: R$ %.2f", valorTotal);

    }


    public static void main(String[] args) {
        new Uni4Exe27();
    }
}
