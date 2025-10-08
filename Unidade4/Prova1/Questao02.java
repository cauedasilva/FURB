import java.util.Scanner;

public class Questao02 {
    Scanner sc = new Scanner(System.in);
    double nota1, nota2, nota3, notaAlta, notaMedia, notaBaixa, mediaSimples, mediaPonderada;
    char opcao;

    public Questao02() {
        informarValor();
        elencarNotas();
        exibirResultado();
    }

    private void informarValor() {
        System.out.println("Digite as três notas: ");
        nota1 = sc.nextDouble();
        nota2 = sc.nextDouble();
        nota3 = sc.nextDouble();
        System.out.println("_Menu: \na) média simples \nb) média ponderada");
        opcao = sc.next().toUpperCase().charAt(0);
    }

    private void exibirResultado() {
        notaAlta += 0.3;
        notaMedia += 0.2;
        notaBaixa += 0.1;

        mediaSimples = (nota1 + nota2 + nota3) / 3;
        mediaPonderada = (notaBaixa * 0.2) + (notaMedia * 0.3) + (notaAlta * 0.5);

        switch (opcao) {
            case 'A':
                System.out.println("O valor da média simples do aluno: " + mediaSimples);
                break;
            case 'B':
                System.out.println("O valor da média ponderada do aluno: " + mediaPonderada);
                break;
            default:
                System.out.println("Valor inválido do Menu");
                break;
        }
    }

    private void elencarNotas() {
        if (nota1 < nota2 && nota1 < nota3) {
            notaBaixa = nota1;
            if (nota2 < nota3) {
                notaMedia = nota2;
                notaAlta = nota3;
            } else {
                notaMedia = nota3;
                notaAlta = nota2;
            }
        } else if (nota2 < nota1 && nota2 < nota3) {
            notaBaixa = nota2;
            if (nota1 < nota3) {
                notaMedia = nota1;
                notaAlta = nota3;
            } else {
                notaMedia = nota3;
                notaAlta = nota1;
            }
        } else {
            notaBaixa = nota3;
            if (nota1 < nota2) {
                notaMedia = nota1;
                notaAlta = nota2;
            } else {
                notaMedia = nota2;
                notaAlta = nota1;
            }
        }
    }


    public static void main(String[] args) {
        new Questao02();
    }
}
