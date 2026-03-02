import java.util.Scanner;

public class Calculadora {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Bem-vindo à CalcFURB! \nInforme o primeiro número: ");
        float num1 = teclado.nextFloat();
        System.out.println("Informe o segundo número: ");
        float num2 = teclado.nextFloat();
        System.out.println("Escolha a opção: \n1-Somar \n2-Dividir \n3-Multiplicar \n4-Subtrair");
        int operacao = teclado.nextInt();
        float resultado = calcular(num1, num2, operacao);
        exibirResultado(operacao, num1, num2, resultado);
        teclado.close();
    }

    public static float calcular(float num1, float num2, int operacao) {
        float resultado;
        switch (operacao) {
            case 1:
                resultado = calcularSoma(num1, num2);
                break;
            case 2:
                resultado = calcularDiv(num1, num2);
                break;
            case 3:
                resultado = calcularMult(num1, num2);
                break;
            case 4:
                resultado = calcularSub(num1, num2);
                break;
            default:
                resultado = 0;
                break;
        }
        return resultado;
    }

    public static float calcularSoma(float num1, float num2) {
        return num1 + num2;
    }

    public static float calcularDiv(float num1, float num2) {
        return num1 / num2;
    }

    public static float calcularMult(float num1, float num2) {
        return num1 * num2;
    }

    public static float calcularSub(float num1, float num2) {
        return num1 - num2;
    }

    public static void exibirResultado(int operacao, float num1, float num2, float resultado) {
        String operacaoString;
        switch (operacao) {
            case 1:
                operacaoString = "soma";
                break;
            case 2: 
                operacaoString = "divisão";
                break;
            case 3:
                operacaoString = "multiplicação";
                break;
            case 4:
                operacaoString = "subtração";
                break;
            default:
                operacaoString = "inválido";
                break;
        }
        
        if (operacaoString != "inválido") {
            System.out.printf("O resultado da %s entre os números %.2f e %.2f é: %.2f", operacaoString, num1, num2, resultado);
        } else {
            System.out.println("A operação escolhida é inválida");
        }
    }
}
