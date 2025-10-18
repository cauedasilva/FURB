public class Uni5Exe02 {
    int somaPares, somaImpares;

    public Uni5Exe02() {
        exibirResultado();
    }

    private void exibirResultado() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                somaPares += i;
            } else {
                somaImpares += i;
            }
        }

        System.out.println("Soma dos numeros pares: " + somaPares);
        System.out.println("Soma dos numeros ímpares: " + somaImpares);
    }

    public static void main(String[] args) {
        new Uni5Exe02();
    }
}
