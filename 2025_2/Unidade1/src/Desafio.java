public class Desafio {
    public static void main(String[] args) {
        double potencia1 = Math.pow(5 / 9, 3);
        double potencia2 = Math.pow(0.4, 12);
        double val2 = potencia1 + (1 / 12) * 47.41 / 12 * 4 + 1 - 3 / 100 * potencia2;
        System.out.println("O resultado é: " + val2);
    }
}