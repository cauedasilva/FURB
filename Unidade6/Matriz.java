import java.util.Random;


public class Matriz {
    int matriz[][] = new int[51][51];
    int somaLinha, somaPrimeiraDiagonal, somaColunas, somaSegundaDiagonal, somaDiagonalTotal, maior = 0;
    
    public Matriz() {
        preencherMatriz();
        calcularLinhas();
        calcularColunas();
        calcularDiagonais();
        calcularMaiorValor();
        exibirMatriz();
    }

    private void preencherMatriz() {
        for (int i = 0; i < matriz.length - 1; i++) {
            for (int j = 0; j < matriz.length - 1; j++) {
                Random random = new Random();
                //matriz[i][j] = random.nextInt(-500, 500);
                matriz[i][j] = 1;
            }
        }
    }

    private void calcularLinhas() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                somaLinha += matriz[i][j];
                if (matriz[i][j] == matriz[i][50]) {
                    matriz[i][j] = somaLinha;
                    somaLinha = 0;
                }
            }

        }
    }

    private void calcularColunas() {
        for (int i = 0; i < matriz.length; i++) {
            somaColunas = 0;
            for (int j = 0; j < matriz.length; j++) {
                somaColunas += matriz[i][j];
                if (matriz[i][j] == matriz[50][j]) {
                    matriz[i][j] = somaColunas;
                }
            }
        }
    }

    private void calcularDiagonais() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == j) {
                    somaPrimeiraDiagonal += matriz[i][j];
                }
            }

        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i + j == matriz.length - 1) {
                    somaSegundaDiagonal += matriz[i][j];
                }
            }
        }

        somaDiagonalTotal = somaPrimeiraDiagonal + somaSegundaDiagonal;
        matriz[50][50] = somaDiagonalTotal;
        System.out.println(somaDiagonalTotal);
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
    }

    public static void main(String[] args) {
        new Matriz();
    }
}
