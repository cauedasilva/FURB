public class Uni5Exe04 {
    float total, x, y;

    public Uni5Exe04() {
        exibirResultado();
    }

    private void exibirResultado() {
        for (int i = 1; i <= 20; i++) {
            x = 2 * i + 1;
            y = i * (i + 1);
            total += x / y;
        }

        System.out.println(total);
    }

    public static void main(String[] args) {
        new Uni5Exe04();
    }
}
