
import java.util.Scanner;

public class Uni5Exe09 {
    Scanner sc = new Scanner(System.in);
    int num, idade, idadeAcimaVinte;
    String nomesDezoito = "", nome;
    
    
    public Uni5Exe09() {
        inserirValor();
        exibirResultado();
    }

    private void inserirValor() {
        System.out.println("Digite um número: ");
        num = sc.nextInt();

        for (int i = 1; i <= num; i++) {
            System.out.println("Informe o nome do aluno: ");
            nome = sc.next();
            System.out.println("Informe a idade do aluno: ");
            idade = sc.nextInt();
            if (idade > 20) {
                idadeAcimaVinte++;
            } else if (idade == 18) {
                nomesDezoito += nome + ", ";
            }
        }
    }

    private void exibirResultado() {
        System.out.println("Quantidade de alunos que tem idade acima de 20 anos: " + idadeAcimaVinte);
        if (nomesDezoito == "") {
            System.out.println("Não há alunos com 18 anos de idade");
        } else {
            System.out.println("Nome dos alunos que tem 18 anos: " + nomesDezoito);
        }
    }

    public static void main(String[] args) {
        new Uni5Exe09();
    }
}
