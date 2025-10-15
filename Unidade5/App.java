public class App {
    public static void main(String[] args) {
        int qtdeImpar = 0, qtdePar = 0;

        for (int i = 100; i >= 0; i--) {
            if (i % 2 == 0) {
                qtdePar++;
            } else {
                qtdeImpar++;
            }
        }

        System.out.println(qtdeImpar);
        System.out.println(qtdePar);
    }
}
