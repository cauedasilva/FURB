import java.util.Scanner;

public class Uni3Exe10 {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        float catetoOposto = lerMedida("cateto oposto");
        float catetoAdjacente = lerMedida("cateto adjacente");
        float hipotenusa = calcularHipotenusa(catetoOposto, catetoAdjacente);
        exibirResultado(hipotenusa);
        teclado.close();
    }

    public static float lerMedida(String medida) {
        System.out.println(medida + ": ");
        float valor = teclado.nextFloat();
        return valor;
    }

    public static float calcularHipotenusa(float catetoOposto, float catetoAdjacente) {
        float hipotenusa = (float) Math.sqrt(Math.pow(catetoOposto, 2) + Math.pow(catetoAdjacente, 2));
        return hipotenusa;
    }

    public static void exibirResultado(float hipotenusa) {
        System.out.printf("A hipotenusa é: %.2f", hipotenusa);
    }
}
