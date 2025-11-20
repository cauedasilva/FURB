import java.util.Random;
import java.util.Scanner;

public class TrabalhoFinal {

    Scanner sc = new Scanner(System.in);

    String matrizTabuleiro[][] = new String[8][8];
    String matrizNavios[][] = new String[8][8];

    String naviosId[] = {"P", "C1", "C2", "D1", "D2", "D3", "S1", "S2", "S3", "S4"}; // navios com id única
    int tamanhos[] = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};

    int partesRestantes[] = new int[tamanhos.length]; // partes restantes de cada navio

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
        while (true) {
            if (tentativas >= maxTentativas) {
                finalizarJogo(false);
                return;
            }

            mostrarTabuleiro();

            System.out.println("Informe coordenadas do ataque:");
            System.out.print("Linha (0-7): ");
            int l = sc.nextInt();
            System.out.print("Coluna (0-7): ");
            int c = sc.nextInt();

            if (!coordenadaValida(l, c)) {
                System.out.println("Coordenada inválida!");
                continue;
            }

            tentativas++;
            processarAtaque(l, c);

            mostrarEstatisticas();

            if (naviosAfundados == naviosId.length) {
                finalizarJogo(true);
                return;
            }
        }
    }

    private void processarAtaque(int l, int c) {

        String alvo = matrizNavios[l][c];

        if (alvo.equals("~")) {
            System.out.println("Água!");
            matrizTabuleiro[l][c] = "X";
            erros++;
            return;
        }

        if (alvo.startsWith("A") || alvo.equals("X")) {
            System.out.println("Você já atirou aqui!");
            return;
        }

        System.out.println("Acertou o navio " + alvo + "!");
        matrizTabuleiro[l][c] = "A";
        matrizNavios[l][c] = "A" + alvo;
        totalAcertos++;

        atualizarPartesRestantes(alvo);

        if (partesRestantes[obterIndexNavio(alvo)] == 0) {
            naviosAfundados++;
            System.out.println("\nO navio " + alvo + " foi AFUNDADO! \n");
            transformarAcertosEmX(alvo);
        }
    }

    private void transformarAcertosEmX(String id) { // marca todas as partes do navio afundado com "X"
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrizNavios[i][j].equals("A" + id)) {
                    matrizNavios[i][j] = "X";
                }
            }
        }    
    }

    private void atualizarPartesRestantes(String id) {
        int pos = obterIndexNavio(id);
        partesRestantes[pos]--;
    }

    private void inicializarMatrizes() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matrizTabuleiro[i][j] = "~";
                matrizNavios[i][j] = "~";
            }
        }
        for (int i = 0; i < tamanhos.length; i++) {
            partesRestantes[i] = tamanhos[i];
        }            
    }

    private void distribuirNavios() {
        for (int i = 0; i < naviosId.length; i++) {
            int[] pos;
            do {
                pos = gerarPosicao(tamanhos[i]);
            } while (checarSobreposicao(pos, tamanhos[i]));

            posicionarNavio(pos, tamanhos[i], naviosId[i]);
        }
    }

    private int[] gerarPosicao(int tamanho) {
        Random r = new Random();
        int direcao = r.nextInt(2);

        int linha = 0;
        int coluna = 0;

        if (direcao == 0) { // horizontal
            linha  = r.nextInt(8);
            coluna = r.nextInt(8);
            while (coluna + tamanho > 8) {
                coluna = r.nextInt(8);
            }
        } else { // vertical
            coluna = r.nextInt(8);
            linha  = r.nextInt(8);
            while (linha + tamanho > 8) {
                linha = r.nextInt(8);
            }
        }

        return new int[] {linha, coluna, direcao};
    }

    private boolean checarSobreposicao(int[] pos, int tamanho) {
        int l = pos[0];
        int c = pos[1];
        int d = pos[2];

        if (d == 0) {
            for (int j = c; j < c + tamanho; j++) {
                if (!matrizNavios[l][j].equals("~")) {
                    return true;
                }
            }
        }
        else {
            for (int i = l; i < l + tamanho; i++) {
                if (!matrizNavios[i][c].equals("~")) {
                    return true;
                }
            }
        }  
        return false;
    }

    private void posicionarNavio(int[] pos, int tamanho, String id) {
        int l = pos[0];
        int c = pos[1];
        int d = pos[2];

        if (d == 0) {
            for (int j = c; j < c + tamanho; j++) {
                matrizNavios[l][j] = id;
            }
        }        
        else {
            for (int i = l; i < l + tamanho; i++) {
                matrizNavios[i][c] = id;
            }    
        }    
    }

    private int obterIndexNavio(String id) {
        for (int i = 0; i < naviosId.length; i++) {
            if (naviosId[i].equals(id)) {
                return i;
            }
        }        
        return -1;
    }

    private void finalizarJogo(boolean venceu) {
        System.out.println("\n===== FIM DO JOGO =====");

        if (venceu) {
            System.out.println("🎉 PARABÉNS, VOCÊ AFUNDOU TODOS OS NAVIOS!");
        }
        else {
            System.out.println("❌ Suas tentativas acabaram… você foi derrotado.");
        }

        revelarNavios();
        mostrarEstatisticasFinais();
    }

    private void revelarNavios() {
        System.out.println("\n--- REVELANDO TODOS OS NAVIOS ---");
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

        System.out.println("\n===== ESTATÍSTICAS =====");
        System.out.println("Tentativa atual: " + tentativas + "/" + maxTentativas);
        System.out.println("Acertos: " + totalAcertos);
        System.out.println("Erros: " + erros);
        System.out.printf("Taxa de acerto: %.2f%%\n", percentual);
        System.out.println("Navios afundados: " + naviosAfundados + "/" + naviosId.length);
        System.out.println("=========================\n");
    }

    private void mostrarEstatisticasFinais() {
        System.out.println("\n===== ESTATÍSTICAS FINAIS =====");

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

        if (pontos >= 400) System.out.println("Classificação: Excelente");
        else if (pontos >= 300) System.out.println("Classificação: Bom");
        else if (pontos >= 200) System.out.println("Classificação: Regular");
        else System.out.println("Classificação: Precisa melhorar");

        System.out.println("==============================\n");
    }

    private void mostrarTabuleiro() {
        System.out.println("\n------ TABULEIRO ------");
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

    private boolean coordenadaValida(int l, int c) {
        return l >= 0 && l < 8 && c >= 0 && c < 8;
    }

    public static void main(String[] args) {
        new TrabalhoFinal();
    }
}
