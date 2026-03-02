import java.util.Scanner;

public class Questao01 {
    Scanner sc = new Scanner(System.in);
    float peso, altura;

    public Questao01() {
        informarValor();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Informe a altura: ");
        altura = sc.nextFloat();
        System.out.println("Informe o peso: ");
        peso = sc.nextFloat();
    }

    private void exibirResultado() {
        if (altura <= 1 && peso <= 50) {
            System.out.println("Subnutrido");
            System.out.println("Perigo de Vida");
        } else if (altura > 5 || peso > 300) {
            System.out.println("Pegar medidas novamente");
        } else {
            System.out.println("Normal");
        }
        System.out.println("Fim");
    }


    public static void main(String[] args) {
        new Questao01();
    }
}
