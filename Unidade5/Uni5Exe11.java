public class Uni5Exe11 {
    int num = 1;

    public Uni5Exe11() {
        exibirResultado();
    }

    private void exibirResultado() {
        for (int i = 1; i < 16; i++) {
            num = num * 3;
        }

        System.out.println("o total é: " + num);
    }

    public static void main(String[] args) {
        new Uni5Exe11();
    }
}
