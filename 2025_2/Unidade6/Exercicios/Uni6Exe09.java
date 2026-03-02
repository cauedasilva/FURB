import java.util.Scanner;

public class Uni6Exe09 {
    Scanner sc = new Scanner(System.in);
    int clientes[][] = new int[30][3];

    public Uni6Exe09() {
        inserirValores();
        exibirResultado();
    }

    private void inserirValores() {
        int contador = 0;

        while (contador < 30) {
            System.out.println("Informe o sexo do cliente (M - 1, F - 2): ");
            int sexo = sc.nextInt();
            if (sexo != 1 && sexo != 2) {
                System.out.println("Opção inválida. Tente novamente.");
            } else {
                System.out.println("Informe a idade do cliente: ");
                int idade = sc.nextInt();
                System.out.println("Informe uma nota para o cinema (0 a 10): ");
                double nota = sc.nextDouble();
                if (nota < 0 || nota > 10) {
                    System.out.println("Nota inválida. Tente novamente.");   
                } else {
                    clientes[contador][0] = sexo;
                    clientes[contador][1] = idade;
                    clientes[contador][2] = (int) nota;
                    contador++;
                }
                
            }
        }
    }

    private void exibirResultado() {
        double notaMedia = 0, notaHomens = 0, notaMulherMaisJovem = 0, acimaMediaMulheres = 0, idadeMulherMaisJovem = 0;

        for (int i = 0; i < clientes.length; i++) {
            notaMedia += clientes[i][2];
            if (clientes[i][0] == 1) {
                notaHomens += clientes[i][2];
            } else if (clientes[i][0] == 2) {
                if (idadeMulherMaisJovem == 0 || clientes[i][1] < idadeMulherMaisJovem) {
                    idadeMulherMaisJovem = clientes[i][1];
                    if (notaMulherMaisJovem == 0 || clientes[i][2] < notaMulherMaisJovem) {
                        notaMulherMaisJovem = clientes[i][2];
                    }
                }
                if (clientes[i][2] > (notaMedia / clientes.length) && clientes[i][1] > 50) {
                    acimaMediaMulheres++;
                }
            }
        }

        System.out.println("Média das notas: " + (notaMedia / clientes.length));
        System.out.println("Média das notas dos homens: " + (notaHomens / clientes.length));
        System.out.println("Nota da mulher mais jovem: " + notaMulherMaisJovem);
        System.out.println("Número de mulheres com mais de 50 anos com nota acima da média: " + acimaMediaMulheres);
    }

    public static void main(String[] args) {
        new Uni6Exe09();
    }
}
