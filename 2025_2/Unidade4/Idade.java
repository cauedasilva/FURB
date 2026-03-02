import java.util.Scanner;

public class Idade {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int idade = teclado.nextInt();
        String fase;

        if (idade >= 0 && idade < 1) {
            fase = "Recém-nascido";
        } else if (idade >= 1 && idade < 3) {
            fase = "Bebê";
        } else if (idade >= 3 && idade < 9) {
            fase = "Criança";
        } else if (idade >= 9 && idade < 12) {
            fase = "Pré-adolescente";
        } else if (idade >= 12 && idade < 16) {
            fase = "Adolescente";
        } else if (idade >= 16 && idade < 18) {
            fase = "Jovem";
        } else if (idade >= 18 && idade < 60) {
            fase = "Adulto";
        } else {
            fase = "Idoso";
        }

        System.out.println("Você é: " + fase);
        teclado.close();
    }
}
