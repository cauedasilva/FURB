import java.util.Random;


public class Matriz {
    int matriz[][] = new int[51][51];
    int somaLinha, somaPrimeiraDiagonal, somaColunas, somaSegundaDiagonal, somaDiagonalTotal, maior = 0;
    
    public Matriz() {
        preencherMatriz();
        calcularDiagonais();
        calcularLinhas();
        calcularColunas();
        calcularMaiorValor();
        exibirMatriz();
    }

    private void preencherMatriz() {
        for (int i = 0; i < matriz.length - 1; i++) {
            for (int j = 0; j < matriz.length - 1; j++) {
                Random random = new Random();
                matriz[i][j] = random.nextInt(-500, 500);
            }
        }
    }

    private void calcularLinhas() {
        for (int i = 0; i < matriz.length; i++) {
            somaLinha = 0;
            for (int j = 0; j < matriz.length; j++) {
                somaLinha += matriz[i][j];
            }
            matriz[i][50] = somaLinha;
        }
    }

    private void calcularColunas() {
        for (int j = 0; j < matriz.length; j++) {
            somaColunas = 0;
            for (int i = 0; i < matriz.length; i++) {
                somaColunas += matriz[i][j];
            }
            matriz[50][j] = somaColunas;
        }
    }

    private void calcularDiagonais() {
        somaPrimeiraDiagonal = 0;
        somaSegundaDiagonal = 0;

        for (int i = 0; i < matriz.length; i++) {
            somaPrimeiraDiagonal += matriz[i][i];
            somaSegundaDiagonal += matriz[i][matriz.length - 1 - i];
        }

        somaDiagonalTotal = somaPrimeiraDiagonal + somaSegundaDiagonal;

        matriz[50][50] = somaDiagonalTotal;
    }

    private void calcularMaiorValor() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] > maior) {
                    maior = matriz[i][j];
                }
            }
        }
    }

    private void exibirMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("O maior número na matriz é: " + maior);
        System.out.println("A soma das diagonais é: " + somaDiagonalTotal);
    }

    public static void main(String[] args) {
        new Matriz();
    }
}
