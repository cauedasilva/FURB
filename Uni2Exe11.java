import java.util.Scanner;

public class Uni2Exe11 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o primeiro valor: ");
        float valA = teclado.nextFloat();
        System.out.println("Digite o segundo valor: ");
        float valB = teclado.nextFloat();
        System.out.println("Digite o terceiro valor: ");
        float valC = teclado.nextFloat();
        float areaTriangulo = (valA * valB) / 2;
        double areaCirculo = (Math.pow(valC, 2)) * Math.PI;
        float areaTrapezio = ((valA + valB) * valC) / 2;
        double areaQuadrado = Math.pow(valB, 2);
        float areaRetangulo = valA * valB;
        System.out.printf("A área do triângulo é: %.3f %n A área do círculo é: %.3f %n A área do trapézio é: %.3f %n A área do quadrado é: %.3f %n A área do retângulo é: %.3f", areaTriangulo, areaCirculo, areaTrapezio, areaQuadrado, areaRetangulo);
        teclado.close();
    }
}
/*
 * Inserido valores: 4, 6 e 8 respectivamente, resultado esperado: 
 * A área do triângulo é: 12,000 
 A área do círculo é: 201,062
 A área do trapézio é: 40,000
 A área do quadrado é: 36,000
 A área do retângulo é: 24,000
 */