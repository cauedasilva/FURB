import java.util.Scanner;

public class Prova2 {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    int posicao = 0;

    public Prova2() {
        inserirValores();
    }

    private void inserirValores() {
        System.out.println("Informe o tamanho da agenda: ");
        int tamanhoVetor = sc.nextInt();
        String nomes[] = new String[tamanhoVetor];
        int telefones[] = new int[tamanhoVetor];
        System.out.println("Informe o número máximo de dígitos totais na agenda: ");
        int digitosTotais = sc.nextInt();

        do {
            System.out.println("Menu: ");
            System.out.println("1 - Adicionar Contato \n2 - Imprimir Agenda \n3 - Contato com maior número de telefone \n4 - Ordenar Agenda \n5 - Remover Contato \n6 - Sair do programa");
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Informe o nome da pessoa que deseja incluir: ");
                    String nome = sc.next();
                    System.out.println("Informe no máximo os últimos quatro dígitos do número de telefone de " + nome + ":");
                    int telefone = sc.nextInt();
                    adicionarContato(nome, telefone, telefones, nomes, digitosTotais);
                    break;
                case 2:
                    imprimirAgenda(telefones, nomes);
                    break;
                case 3:
                    contatoMaiorTelefone(telefones, nomes);
                    break;
                case 4:
                    ordenarAgenda(telefones, nomes);
                    break;
                case 5:
                    removerContato(telefones, nomes);
                    break;
                case 6:
                    continuar = false;
                    break;   
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (continuar);
    }

    private void adicionarContato(String nome, int telefone, int telefones[], String nomes[], int digitosTotais) {
        int num = atualizarTotal(telefones, telefone);

        if (num > digitosTotais) {
            System.out.println("Não é possível adicionar o contato, o número total de dígitos irá ser ultrapassado.");
        } else if (posicao >= nomes.length) {
            System.out.println("Não é possível adicionar o contato, o número total de contatos irá ser ultrapassado.");
        } else {
            atualizarNomes(nomes, nome);
            atualizarTelefones(telefones, telefone);
            posicao++;
        }
    }

    private int[] atualizarTelefones(int telefones[], int telefone) {
        telefones[posicao] = telefone;
        return telefones;
    }

    private String[] atualizarNomes(String nomes[], String nome) {
        nomes[posicao] = nome;
        return nomes;
    }

    private int atualizarTotal(int digitos[], int telefone) {
        String tempString = telefone + "";
        int digitosTotais = tempString.length();

        for (int i = 0; i < posicao; i++) {
            tempString = digitos[i] + "";
            digitosTotais += tempString.length();
        }
        
        return digitosTotais;
    }

    private void imprimirAgenda(int telefones[], String nomes[]) {
        for (int i = posicao; i > 0; i--) {
            System.out.println("Nome: " + nomes[i - 1] + "; Telefone: " + telefones[i - 1]);
            
        }
    }

    private void contatoMaiorTelefone(int telefones[], String nomes[]) {
        int maiorNumero = 0;
        String nome = "";

        for (int i = 0; i < posicao; i++) {
            if (maiorNumero == 0) {
                maiorNumero = telefones[i];
                nome = nomes[i];
            } else {
                if (telefones[i] > maiorNumero) {
                    maiorNumero = telefones[i];
                    nome = nomes[i];
                }
            }
        }

        System.out.println("O maior número de telefone é o de: " + nome);
    }

    private void ordenarAgenda(int telefones[], String nomes[]) {
        int temp;
        
        for (int i = 0; i < posicao - 1; i++) {
            if (telefones[i] > telefones[i + 1]) {
                temp = telefones[i];
                telefones[i] = telefones[i + 1];
                telefones[i + 1] = temp;
                i = -1;
            }
        }
    }

    private void removerContato(int telefones[], String nomes[]) {
        System.out.println("Insira o nome da pessoa que deseja excluir da agenda: ");
        String nome = sc.next().toLowerCase();
        int num = pesquisarNome(nomes, nome);

        if (num != -1) {
            for (int i = posicao; i < (posicao - 1); i++) {
                nomes[i] = nomes[i + 1];
                telefones[i] = telefones[i + 1];
            }
            System.out.println("Usuário excluído.");
            posicao--;
        } else {
            System.out.println("Não foi encontrado o nome digitado!");
        }
    }

    private int pesquisarNome(String nomes[], String nome) {
        for (int i = 0; i < posicao; i++) {
            if (nome.equals(nomes[i])) {
                System.out.println("Encontrado nome na posição: [" + i + "]");
                return i;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        new Prova2();
    }
}