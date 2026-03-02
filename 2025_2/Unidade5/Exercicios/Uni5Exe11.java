public class Uni5Exe11 {
    int num = 1, total;

    public Uni5Exe11() {
        exibirResultado();
    }

    private void exibirResultado() {
        for (int i = 0; i < 16; i++) {
            total = total + num;
            num = num * 3;
            System.out.println(total);
        }

        System.out.println("o total é: " + total);
    }

    public static void main(String[] args) {
        new Uni5Exe11();
    }
}
