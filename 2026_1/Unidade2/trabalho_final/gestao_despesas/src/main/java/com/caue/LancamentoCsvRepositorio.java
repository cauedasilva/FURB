package com.caue;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

// Esta classe é o "banco de dados" do sistema, conforme pedido no enunciado:
// os objetos Receita/Despesa (que herdam de Lancamento) são convertidos em
// linhas de texto e gravados em um arquivo .csv, e o caminho inverso é feito
// ao iniciar o programa para reconstruir os objetos a partir do arquivo.
public class LancamentoCsvRepositorio implements LancamentoRepositorio {

    private static String SEPARADOR = ";";
    private static String CABECALHO = "tipo;descricao;valor;data;categoria";
    private static String TIPO_RECEITA = "RECEITA";
    private static String TIPO_DESPESA = "DESPESA";

    private String caminhoArquivo;

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------
    public LancamentoCsvRepositorio(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        criarArquivoSeNaoExistir();
    }

    // -------------------------------------------------------------------------
    // Métodos da interface LancamentoRepository
    // -------------------------------------------------------------------------
    @Override
    public ArrayList<Lancamento> carregarTodos() {
        ArrayList<Lancamento> lancamentos = new ArrayList<>();
        Path path = Paths.get(caminhoArquivo);

        try (BufferedReader leitor = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String linha = leitor.readLine(); // descarta o cabeçalho
            while ((linha = leitor.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    Lancamento lancamento = converterLinhaParaLancamento(linha);
                    if (lancamento != null) {
                        lancamentos.add(lancamento);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
        return lancamentos;
    }

    @Override
    public void salvarTodos(ArrayList<Lancamento> lancamentos) {
        try (FileWriter escritor = new FileWriter(caminhoArquivo, StandardCharsets.UTF_8)) {
            escritor.write(CABECALHO + System.lineSeparator());
            for (Lancamento lancamento : lancamentos) {
                String linha = converterLancamentoParaLinha(lancamento);
                if (linha != null) {
                    escritor.write(linha + System.lineSeparator());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo CSV: " + e.getMessage());
        }
    }

    // -------------------------------------------------------------------------
    // Conversão linha CSV -> objeto de domínio
    // -------------------------------------------------------------------------
    private Lancamento converterLinhaParaLancamento(String linha) {
        String[] campos = linha.split(SEPARADOR);
        if (campos.length < 5) {
            return null;
        }

        String tipo = campos[0].trim();

        if (TIPO_RECEITA.equals(tipo)) {
            return converterLinhaParaReceita(campos);
        } else if (TIPO_DESPESA.equals(tipo)) {
            return converterLinhaParaDespesa(campos);
        }
        return null;
    }

    private Receita converterLinhaParaReceita(String[] campos) {
        String descricao = campos[1];
        double valor = Double.parseDouble(campos[2]);
        LocalDate data = LocalDate.parse(campos[3]);
        CategoriaReceita categoria = CategoriaReceita.valueOf(campos[4].trim());
        return new Receita(descricao, valor, data, categoria);
    }

    private Despesa converterLinhaParaDespesa(String[] campos) {
        String descricao = campos[1];
        double valor = Double.parseDouble(campos[2]);
        LocalDate data = LocalDate.parse(campos[3]);
        CategoriaDespesa categoria = CategoriaDespesa.valueOf(campos[4].trim());
        return new Despesa(descricao, valor, data, categoria);
    }

    // -------------------------------------------------------------------------
    // Conversão objeto de domínio -> linha CSV
    // -------------------------------------------------------------------------
    private String converterLancamentoParaLinha(Lancamento lancamento) {
        if (lancamento instanceof Receita) {
            Receita receita = (Receita) lancamento;
            return String.join(SEPARADOR,
                    TIPO_RECEITA,
                    receita.getDescricao(),
                    String.valueOf(receita.getValor()),
                    receita.getData().toString(),
                    receita.getCategoriaReceita().toString());
        } else if (lancamento instanceof Despesa) {
            Despesa despesa = (Despesa) lancamento;
            return String.join(SEPARADOR,
                    TIPO_DESPESA,
                    despesa.getDescricao(),
                    String.valueOf(despesa.getValor()),
                    despesa.getData().toString(),
                    despesa.getCategoriaDespesa().toString());
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // Garante que o arquivo "banco de dados" exista antes da primeira leitura
    // -------------------------------------------------------------------------
    private void criarArquivoSeNaoExistir() {
        Path path = Paths.get(caminhoArquivo);
        if (!Files.exists(path)) {
            try (FileWriter escritor = new FileWriter(caminhoArquivo, StandardCharsets.UTF_8)) {
                escritor.write(CABECALHO + System.lineSeparator());
            } catch (IOException e) {
                System.err.println("Erro ao criar o arquivo CSV: " + e.getMessage());
            }
        }
    }
}
