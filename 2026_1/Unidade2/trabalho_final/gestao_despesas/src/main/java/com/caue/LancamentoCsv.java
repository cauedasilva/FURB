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

public class LancamentoCsv {
    private static String SEPARADOR = ";";
    private static String CABECALHO = "tipo;descricao;valor;data;categoria";
    private static String TIPO_RECEITA = "RECEITA";
    private static String TIPO_DESPESA = "DESPESA";
    private String caminhoArquivo;

    /**
     * Método constructor da classe LancamentoCsv
     * @param caminhoArquivo caminho do arquivo csv no sistema
     */
    public LancamentoCsv(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        criarArquivoSeNaoExistir();
    }

    /**
     * Método carregarTodos carrega todos os dados já armazenados no arquivo csv, converte para objeto lancamento e adiciona a uma array de lancamentos
     * @return ArrayList de lancamentos convertidos em objeto a partir do csv
     */
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

    /**
     * Método salvarTodos salva todos os objetos do array lancamentos em csv, é feito a conversão de objeto para texto antes de salvar
     * @param lancamentos arrayList lancamentos a ser salvo
     */
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

    /**
     * Método converterLinhaParaLancamento converte linha de texto no csv para atributos de um objeto da classe Lancamento
     * @param linha linha a ser lida do arquivo csv
     * @return objeto lancamento para ser adicionado na array
     */
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

    /**
     * Método converterLinhaParaReceita usado no método converterLinhaParaLancamento, define se linha é Receita e retorna objeto correto para ser adicionado no array
     * @param campos da linha do csv
     * @return objeto Receita
     */
    private Receita converterLinhaParaReceita(String[] campos) {
        String descricao = campos[1];
        double valor = Double.parseDouble(campos[2]);
        LocalDate data = LocalDate.parse(campos[3]);
        CategoriaReceita categoria = CategoriaReceita.valueOf(campos[4].trim());
        return new Receita(descricao, valor, data, categoria);
    }

    /**
     * Método converterLinhaParaDespesa usado no método converterLinhaParaLancamento, define se linha é Despesa e retorna objeto correto para ser adicionado no array
     * @param campos da linha do csv
     * @return objeto Despesa
     */
    private Despesa converterLinhaParaDespesa(String[] campos) {
        String descricao = campos[1];
        double valor = Double.parseDouble(campos[2]);
        LocalDate data = LocalDate.parse(campos[3]);
        CategoriaDespesa categoria = CategoriaDespesa.valueOf(campos[4].trim());
        return new Despesa(descricao, valor, data, categoria);
    }

    /**
     * Método converterLancamentoParaLinha converte atributos de um objeto da classe Lancamento para linha de texto no csv 
     * @param lancamento objeto a ser convertido
     * @return String para ser adicionado no csv
     */
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

    /**
     * Método criarArquivoSeNaoExistir cria arquivo csv caso não existir antes de inicialização do app
     */
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
