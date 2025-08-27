import java.text.DecimalFormat;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        escreverNaTela();
        escrevaUmTextoNaTela("Novo texto");
        somarDoisNumeros(5, 10);
        int resultado = multipicarDoisNumeros(10, 2);
        escrevaUmTextoNaTela("" + resultado);
        double resultadoDivisao = dividirDoisNumeros(4.38, 10);
        escreverFormatado(resultadoDivisao);
    }
    private static void escreverFormatado(double resultadoDivisao) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(resultadoDivisao));
    }
    private static void escrevaUmTextoNaTela(String texto) {
        System.out.println(texto);
    }
    public static void escreverNaTela() {
        System.out.println("Escrevendo na tela");
    }
    public static void somarDoisNumeros(int num1, int num2) {
        System.out.println(num1 + num2);
    }
    public static int multipicarDoisNumeros(int a, int b) {
        return a * b;
    }
    public static double dividirDoisNumeros(double a, double b) {
        return a / b;
    }

}
