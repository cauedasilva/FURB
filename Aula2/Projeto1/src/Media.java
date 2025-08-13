import java.util.Scanner;

public class Media {    
    public static void main(String[] args) {
        // Professor quer receber o nome do aluno e três notas
        // Calcular média e exibir o nome do aluno e a média do mesmo
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do aluno: ");
        String nome = teclado.nextLine();
        System.out.println(nome);
    }
}
