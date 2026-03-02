public class Uni5Exe03 {
    float total;

    public Uni5Exe03() {
        exibirResultado();
    }

    private void exibirResultado() {
        for (float i = 1; i <= 100; i++) {
            total += 1 / i;
        }

        System.out.println(total);
    }

    public static void main(String[] args) {
        new Uni5Exe03();
    }
}
