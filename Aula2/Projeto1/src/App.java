public class App {
    public static void main(String[] args) {
        int num1 = 5;
        int num2 = 10;
        int valor = num1 + num2;
        System.out.println("A soma é: " + valor);

        int subtracao = num2 - num1;
        int mult = num1 * num2;

        System.out.println("A subtração é: " + subtracao + " e a multiplicação é: " + mult);

        double divisao = (double)num1 / num2;
        System.out.println("A divisão é: " + divisao);

        int resto = num1 % num2;
        System.out.println("O resto da divisão é: " + resto);

        float val1 = 4.34f;
        float val2 = 3.14f;
        double resultado = val1 / val2;
        System.out.println("O resultado da divisão decimal é: " + Math.round(resultado));
        System.out.println("O resultado da divisão decimal é: " + Math.floor(resultado));
        System.out.println("O resultado da divisão decimal é: " + Math.ceil(resultado));
        System.out.printf("%.2f%n", resultado);
        System.out.printf("%.4f%n", resultado);

        int base = num1;
        int expoente = 2;
        double potencia = Math.pow(base, expoente);
        System.out.println("A potenciação de: " + num1 + ", é: " + Math.round(potencia));

        double raizQuadrada = Math.sqrt(potencia);
        System.out.println("A raiz quadrada de: " + potencia + ", é: " + raizQuadrada);
        double raizCubica = Math.cbrt(125);
        System.out.println("A raiz cubíca de: 125, é: " + raizCubica);
        double pi = Math.PI;
        System.out.println("O Pi é: " + pi);
        System.out.println(Math.pow(pi, 2));
    }
}