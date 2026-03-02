import java.util.Scanner;

public class Uni5Exe32 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    int dias, diaSemana;

    public Uni5Exe32() {
        inserirValor();
    }

    private void inserirValor() {
        while (continuar) {
            System.out.println("Informe o dia da semana que inicia o mês: ");
            diaSemana = sc.nextInt();    
            System.out.println("Informe a quantidade de dias do mês: ");
            dias = sc.nextInt();
        
            if (diaSemana < 1 || diaSemana > 7 || dias < 28 || dias > 31) {
                System.out.println("Valores inválidos.");
            } else {
                calcularMes();
                continuar = false;
            }
        }
    }

    private void calcularMes() {
        System.out.println("Dom Seg Ter Qua Qui Sex Sab");
        for (int i = 1; i < diaSemana; i++) {
            System.out.print("    ");
        }

        int diaAtual = diaSemana;
        for (int i = 1; i <= dias; i++) {
            if (i < 10) {
                System.out.print(" " + i + "  ");
            } else {
                System.out.print(i + "  ");
            }
            if (diaAtual == 7) {
                System.out.println();
                diaAtual = 1;
            } else {
                diaAtual++;
            }
        }
    }

    public static void main(String[] args) {
        new Uni5Exe32();
    }
}
