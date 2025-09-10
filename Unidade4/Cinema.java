import java.util.Scanner;

public class Cinema {
        public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int idade;
        System.out.println("Digite a sua idade: ");
        idade = teclado.nextInt();
        char estudante, doadorDeSangue;
        System.out.println("Você é estudante? (Digite S ou N)");
        estudante = teclado.next().toUpperCase().charAt(0);
        // coletando primeiro caractere
        System.out.println("Você é doador de sangue? (Digite S ou N)");
        doadorDeSangue = teclado.next().toUpperCase().charAt(0);
        String tipoIngresso;
        double valorIngresso = 28.00;

        if (idade < 18 || idade > 65 || doadorDeSangue == 'S' || estudante == 'S') {
            // char é aspas simples
            tipoIngresso = "Paga meia entrada! \nO valor do ingresso é %.2f";
            valorIngresso = valorIngresso / 2;
        } else {
            tipoIngresso = "Paga ingresso inteiro \nO valor do ingresso é %.2f";
        }
        System.out.printf(tipoIngresso, valorIngresso);
        
        teclado.close();
    }
}
