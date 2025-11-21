import java.util.Random;
import java.util.Scanner;

public class TrabalhoFinal {
    Scanner sc = new Scanner(System.in);

    String matrizTabuleiro[][] = new String[8][8];
    String matrizNavios[][] = new String[8][8];
    String naviosId[] = {"P", "C1", "C2", "D1", "D2", "D3", "S1", "S2", "S3", "S4"}; // navios com id única
    int tamanhos[] = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1}; // tamanhos de cada navio
    int partesRestantes[] = new int[tamanhos.length]; // partes restantes de cada navio

    // estatísticas do jogo
    int tentativas = 0;
    int maxTentativas = 30;
    int totalAcertos = 0;
    int erros = 0;
    int naviosAfundados = 0;

    public TrabalhoFinal() {
        inicializarMatrizes();
        distribuirNavios();
        iniciarJogo();
    }

    private void iniciarJogo() {
        while (true) { // loop do jogo
            if (tentativas >= maxTentativas) {
                finalizarJogo(false);
                break;
            }

            mostrarTabuleiro();

            System.out.println("Informe coordenadas do ataque:");
            System.out.print("Linha (0-7): ");
            int linha = sc.nextInt();
            System.out.print("Coluna (0-7): ");
            int coluna = sc.nextInt();

            if (!coordenadaValida(linha, coluna)) {
                System.out.println("Coordenada inválida!");
            } else {
                tentativas++;
                processarAtaque(linha, coluna);
                mostrarEstatisticas(); // mostra estatísticas após o ataque somente

                if (naviosAfundados == naviosId.length) {
                    finalizarJogo(true);
                    break;
                }
            }
        }
    }

    private void processarAtaque(int linha, int coluna) {
        String alvo = matrizNavios[linha][coluna];

        if (alvo.equals("~")) {
            System.out.println("Água!");
            matrizTabuleiro[linha][coluna] = "X";
            erros++;
            return; // sai da função se acertou água
        }

        if (alvo.startsWith("A") || alvo.equals("X")) {
            System.out.println("Você já atirou aqui!");
            return;
        } // sai da função se já atirou aqui

        System.out.println("Acertou o navio " + alvo + "!");

        matrizTabuleiro[linha][coluna] = "A";
        matrizNavios[linha][coluna] = "A" + alvo; // marca acerto na matriz oculta
        totalAcertos++;

        atualizarPartesRestantes(alvo); // diminui a parte restante do navio
        int id = obterIndexNavio(alvo); // obtém o índice do navio dentro do vetor

        if (id != -1 && partesRestantes[id] == 0) { // checa se o id do navio é válido e se todas as partes foram acertadas
            naviosAfundados++;
            System.out.println("\nO navio " + alvo + " foi afundado!\n");

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (matrizNavios[i][j].equals("A" + id)) {
                        matrizNavios[i][j] = "X";
                    }
                }
            }  
        }
    }

    private void atualizarPartesRestantes(String id) {
        int pos = obterIndexNavio(id); // obtém o índice do navio dentro do vetor
        partesRestantes[pos]--;
    }

    private void inicializarMatrizes() { // inicializa as duas matrizes, oculta e visível para o usuário
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrizTabuleiro[i][j] = "~";
                matrizNavios[i][j] = "~";
            }
        }
        for (int i = 0; i < tamanhos.length; i++) {
            partesRestantes[i] = tamanhos[i]; // inicializa partes restantes com o tamanho do navio
        }            
    }

    private void distribuirNavios() { // distribui os navios aleatoriamente na matriz de navios
        for (int i = 0; i < naviosId.length; i++) {
            int[] pos;
            do {
                pos = gerarPosicao(tamanhos[i]);
            } while (checarSobreposicao(pos, tamanhos[i])); // repete até achar uma posição que não esteja ocupada

            posicionarNavio(pos, tamanhos[i], naviosId[i]); // posiciona o navio na matriz
        }
    }

    private int[] gerarPosicao(int tamanho) { // gera posição aleatória para o navio
        Random r = new Random();
        int direcao = r.nextInt(2);

        int linha = 0;
        int coluna = 0;

        if (direcao == 0) { // horizontal
            linha  = r.nextInt(8);
            coluna = r.nextInt(8);
            while (coluna + tamanho > 8) {
                coluna = r.nextInt(8); // garante que o navio caiba na matriz
            }
        } else { // vertical
            coluna = r.nextInt(8);
            linha  = r.nextInt(8);
            while (linha + tamanho > 8) {
                linha = r.nextInt(8); // garante que o navio caiba na matriz
            }
        }

        int pos[] = {linha, coluna, direcao};
        return pos;
    }

    private boolean checarSobreposicao(int[] pos, int tamanho) {
        int linha = pos[0];
        int coluna = pos[1];
        int direcao = pos[2];

        if (direcao == 0) { // horizontal
            for (int j = coluna; j < coluna + tamanho; j++) {
                if (!matrizNavios[linha][j].equals("~")) {
                    return true;
                }
            }
        } else { // vertical
            for (int i = linha; i < linha + tamanho; i++) {
                if (!matrizNavios[i][coluna].equals("~")) {
                    return true;
                }
            }
        }
        return false; // retorna falso se não houver sobreposição
    }

    private void posicionarNavio(int[] pos, int tamanho, String id) {
        int linha = pos[0];
        int coluna = pos[1];
        int direcao = pos[2];

        if (direcao == 0) { // horizontal
            for (int j = coluna; j < coluna + tamanho; j++) {
                matrizNavios[linha][j] = id;
            }
        } else { // vertical
            for (int i = linha; i < linha + tamanho; i++) {
                matrizNavios[i][coluna] = id;
            }    
        }    
    }

    private int obterIndexNavio(String id) {
        for (int i = 0; i < naviosId.length; i++) {
            if (naviosId[i].equals(id)) { // encontrou o navio
                return i;
            }
        }
        return -1;
    }

    private void finalizarJogo(boolean venceu) { 
        System.out.println("\n----- Fim de jogo -----");

        if (venceu) {
            System.out.println("Todos os navios foram afundados!");
        } else {
            System.out.println("Tentativas acabaram. Você perdeu.");
        }

        revelarNavios(); // mostra a matriz de navios que estava oculta
        mostrarEstatisticasFinais(); // mostra estatísticas finais do jogo
    }

    private void revelarNavios() {
        System.out.println("\n--- Revelando posição de todos os navios ---");
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(matrizNavios[i][j] + " ");
            }    
            System.out.println();
        }
        System.out.println();
    }

    private void mostrarEstatisticas() {
        double percentual;
        if (tentativas == 0) {
            percentual = 0;
        } else {
            percentual = totalAcertos * 100.0 / tentativas;
        }

        System.out.println("\n----- Estatísticas -----");
        System.out.println("Tentativa atual: " + tentativas + "/" + maxTentativas);
        System.out.println("Acertos: " + totalAcertos);
        System.out.println("Erros: " + erros);
        System.out.printf("Taxa de acerto: %.2f%%\n", percentual);
        System.out.println("Navios afundados: " + naviosAfundados + "/" + naviosId.length);
        System.out.println("----------------------\n");
    }

    private void mostrarEstatisticasFinais() {
        System.out.println("\n----- Estatísticas finais -----");

        double percentual;
        if (tentativas == 0) {
            percentual = 0;
        } else {
            percentual = totalAcertos * 100.0 / tentativas;
        }
        int pontos = (totalAcertos * 10) + (naviosAfundados * 50) - (erros * 2);

        System.out.println("Tentativas utilizadas: " + tentativas);
        System.out.println("Total de acertos: " + totalAcertos);
        System.out.println("Erros: " + erros);
        System.out.printf("Taxa de acerto: %.2f%%\n", percentual);
        System.out.println("Navios afundados: " + naviosAfundados + "/" + naviosId.length);
        System.out.println("Pontuação final: " + pontos);

        if (pontos >= 400) {
            System.out.println("Classificação: Excelente");
        } else if (pontos >= 300) { 
            System.out.println("Classificação: Bom");
        } else if (pontos >= 200) { 
            System.out.println("Classificação: Regular");
        } else {
            System.out.println("Classificação: Precisa melhorar");
        }
        System.out.println("------------------------------\n");
    }

    private void mostrarTabuleiro() {
        System.out.println("\n------ Tabuleiro ------");
        System.out.println("  0 1 2 3 4 5 6 7");

        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(matrizTabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }

    private boolean coordenadaValida(int linha, int coluna) {
        boolean valido = false;
        if (linha >= 0 && linha < 8) {
            if (coluna >= 0 && coluna < 8) {
                valido = true;
            }
        }
        return valido; // retorna se está dentro do tabuleiro
    }

    public static void main(String[] args) {
        new TrabalhoFinal();
    }
}
