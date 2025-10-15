public class JogoDaVelha {
    public JogoDaVelha() {
        tabuleiro();
    }

    private void tabuleiro() {
        for (int j = 2; j >= 0; j--) {
            for (int i = 0; i < 3; i++) {
                if (i < 2 && j > 0) {
                    System.out.print("__|");
                } else if (j == 0 && i < 2) {
                    System.out.print("  |");
                }  else if (j == 0 && i == 2) {
                    System.out.print("  ");
                } else {
                    System.out.print("__");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new JogoDaVelha();
    }
}
