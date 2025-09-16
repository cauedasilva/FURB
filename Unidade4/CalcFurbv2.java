import java.util.Scanner;

public class CalcFurbv2 {
    double num1, num2, resultado;
    Scanner sc = new Scanner(System.in);
    
    public CalcFurbv2() { //construtor da classe, método com nome da classe
        System.out.println("Bem-vindo à CalcFURB!");
        inicializar();
        finalizar();
    }

    private void finalizar() {
        System.out.println("Deseja realizar outra operação? \n1-Sim \n2-Não");
        int opcao = sc.nextInt();
        if (opcao == 1) {
            inicializar();
            finalizar();
        } else {
            System.out.println("Obrigado por usar a CalcFURB!");
            sc.close();
        }
    }

    private void inicializar() {
        informarDoisNumeros();
        escolherOpcao();
        exibirResultado();
    }

    private void exibirResultado() {
        System.out.println("O resultado é: "  + resultado);
    }

    private void escolherOpcao() {
        System.out.println("Escolha a operação numérica: \n1-Somar \n2-Dividir \n3-Multiplicar \n4-Subtrair");

        int opcao = sc.nextInt();
        switch (opcao) { //variáveis são públicas, portanto não é necessário passar var nos atributos
            case 1:
                resultado = calcularSoma();
                break;
            case 2:
                resultado = calcularDiv();
                break;
            case 3:
                resultado = calcularMult();
                break;
            case 4:
                resultado = calcularSub();
                break;
            default:
                System.out.println("Opção inválida!");
                escolherOpcao(); //método recursivo
                break;
        }
    }

    private double calcularSoma() {
        return num1 + num2;
    }

    private double calcularDiv() {
        if (num2 > 0) {
            return num1 / num2;
        } else {
            return 0;
        }
    }

    private double calcularMult() {
        return num1 * num2;
    }

    private double calcularSub() {
        return num1 - num2;
    }

    private void informarDoisNumeros() {
        System.out.println("Informe o primeiro número: ");        
        num1 = sc.nextDouble();
        System.out.println("Informe o segundo número: ");
        num2 = sc.nextDouble();

    }

    public static void main(String[] args) {
        new CalcFurbv2();
    }

}
