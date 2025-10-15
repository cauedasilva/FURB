public class Uni5Exe10 {
    int parte1, parte2, num;

    public Uni5Exe10() {
        exibirResultado();
    }

    private void exibirResultado() {
        for (int i = 0; i < 999999999; i++) {
            parte1 = i / 100;
            parte2 = i % 100;

            if ((parte1 + parte2) * (parte1 + parte2) == i) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        new Uni5Exe10();
    }
}