public class Aluno {
    String nome;
    int numeroDeMatricula;
    char sexo;
    final int numeroDaEscola = 12345; // final significa que valor não é alterável
    int anoNascimento, mesNascimento, diaNascimento; // declarando var inline

    public Aluno() { 
        estudar();
    } // construtor da classe, método com o mesmo nome da classe

    public int informarNumeroDeMatricula() {
        return this.numeroDeMatricula;
    }
    public void estudar() {
        System.out.println("Estudando");
    }

    public static void main(String[] args) {
        new Aluno();
    }
}
