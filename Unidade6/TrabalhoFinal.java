import java.util.Random;
import java.util.Scanner;

public class TrabalhoFinal {
    Scanner sc = new Scanner(System.in);
    int matrizTabuleiro[][] = new int[8][8];
    int matrizNavios[][] = new int[8][8];

    public TrabalhoFinal() {
        tabuleiro();
    }

    private void tabuleiro() {
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print("~ ");
            }
            System.out.println();
        }
    }

    private void posicionarNavios() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int  posPortaAviao = Math.random(0, 4);
            }
        }
            
        
    }

    public static void main(String[] args) {
        new TrabalhoFinal();
    }
}
