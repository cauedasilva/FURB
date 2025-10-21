public class Uni5Exe10 {
    public Uni5Exe10() {
        exibirResultado();
    }

    private void exibirResultado() {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                int soma = i + j;
                String potencia = "" + (int) Math.pow(soma, 2);
                String numeros =  "" + i + j;
                if (potencia.equals(numeros)) {
                    System.out.println(i + " + " + j + " = " + soma + ";" + " -> " + soma + "²" + " = " + potencia);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Uni5Exe10();
    }
}
