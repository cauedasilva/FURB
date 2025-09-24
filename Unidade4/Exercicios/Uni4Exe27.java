import java.util.Scanner;

public class Uni4Exe27 {
    Scanner sc = new Scanner(System.in);
    int minutosSaidaTotal, minutosChegadaTotal, horaChegada, minSaida, horaSaida, minChegada, horasEstacionado, minutosEstacionado, minutosTotais;
    float horasParaCobrar, valorTotal;

    public Uni4Exe27() {
        informarValor();
        calcularTempo();
        calcularValor();
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

    private void calcularTempo() {
        minutosChegadaTotal = horaChegada * 60 + minChegada;
        minutosSaidaTotal = horaSaida * 60 + minSaida;
        minutosTotais = minutosSaidaTotal - minutosChegadaTotal;
        horasEstacionado = minutosTotais / 60;
        minutosEstacionado = minutosTotais % 60;

        if (minutosTotais < 30) {
            horasParaCobrar = 1;
        } else if (minutosEstacionado <= 29) {
            horasParaCobrar = horasEstacionado;
        } else {
            horasParaCobrar = horasEstacionado + 1;
        }
    }

    private void calcularValor() {
        float valorPrimeirasHoras = 5.0f;
        float valorTerceiraHora = 7.5f;
        float ValorDemaisHoras = 10.0f;

        if (horasParaCobrar <= 2) {
            valorTotal = valorPrimeirasHoras * horasParaCobrar;
        } else if (horasParaCobrar == 3) {
            valorTotal = (valorPrimeirasHoras * 2) + valorTerceiraHora;
        } else if (horasParaCobrar == 4) {
            valorTotal = (valorPrimeirasHoras * 2) + (valorTerceiraHora *2);
        } else {
            valorTotal = (valorPrimeirasHoras * 2) + (valorTerceiraHora *2) + (ValorDemaisHoras * (horasParaCobrar - 4));
        }
    }

    private void exibirResultado() {
        if (horaChegada < 0 || horaChegada > 23 || horaSaida < 0 || horaSaida > 23 || minChegada < 0 || minChegada > 59 || minSaida < 0 || minSaida > 59 || minutosSaidaTotal < minutosChegadaTotal) {
            System.out.println("Horário inválido");
        } else {
            System.out.printf("O valor a ser pago é: R$ %.2f", valorTotal);
        }
    }

    public static void main(String[] args) {
        new Uni4Exe27();
    }
}
