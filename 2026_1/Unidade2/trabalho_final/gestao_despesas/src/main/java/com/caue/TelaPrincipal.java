package com.caue;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaPrincipal extends JFrame {
    private ControleFinanceiro controleFinanceiro;
    private LancamentoCsv repositorio;

    private JTable tabelaLancamentos;
    private LancamentoTableModel tableModel;
    private JLabel lblSaldoAtual;
    private JLabel lblSaldoTotal;
    private JButton btnAdicionarReceita;
    private JButton btnAdicionarDespesa;
    private JButton btnRemover;
    private JButton btnExtrato;

    /**
     * Método constructor da classe TelaPrincipal   
     * @param repositorio objeto da classe LancamentoCsv a ser exibido na interface
     */
    public TelaPrincipal(LancamentoCsv repositorio) {
        super("Controle Financeiro");
        this.repositorio = repositorio;
        this.controleFinanceiro = new ControleFinanceiro();

        iniciarInterface();
        montarLayout();
        configurarEventos();
        carregarDadosIniciais();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 450);
        setLocationRelativeTo(null);
    }

    /**
     * Método iniciarInterface carrega todos os componentes da JTable
     */
    private void iniciarInterface() {
        tableModel = new LancamentoTableModel(controleFinanceiro.listarLancamentos());
        tabelaLancamentos = new JTable(tableModel);

        lblSaldoAtual = new JLabel("Saldo Atual: R$ 0,00");
        lblSaldoTotal = new JLabel("Saldo Total: R$ 0,00");

        btnAdicionarReceita = new JButton("Nova Receita");
        btnAdicionarDespesa = new JButton("Nova Despesa");
        btnRemover = new JButton("Remover Selecionado");
        btnExtrato = new JButton("Ver Extrato");
    }

    /**
     * Método montarLayout carrega o layout/ui da interface
     */
    private void montarLayout() {
        setLayout(new BorderLayout(10, 10));

        JPanel painelBotoes = new JPanel(new FlowLayout());
        painelBotoes.add(btnAdicionarReceita);
        painelBotoes.add(btnAdicionarDespesa);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnExtrato);

        JPanel painelSaldos = new JPanel(new FlowLayout());
        painelSaldos.add(lblSaldoAtual);
        painelSaldos.add(lblSaldoTotal);

        add(painelBotoes, BorderLayout.NORTH);
        add(new JScrollPane(tabelaLancamentos), BorderLayout.CENTER);
        add(painelSaldos, BorderLayout.SOUTH);
    }

    /**
     * Método configurarEventos define os eventos de cada botão disponível na interface
     */
    private void configurarEventos() {
        btnAdicionarReceita.addActionListener(e -> abrirDialogReceita());
        btnAdicionarDespesa.addActionListener(e -> abrirDialogDespesa());
        btnRemover.addActionListener(e -> removerLancamentoSelecionado());
        btnExtrato.addActionListener(e -> exibirExtrato());
    }

    /**
     * Método carregarDadosIniciais carrega todos os dados salvos no csv e exibe na interface
     */
    private void carregarDadosIniciais() {
        List<Lancamento> salvos = repositorio.carregarTodos();

        for (Lancamento l : salvos) {
            if (l instanceof Receita) {
                controleFinanceiro.adicionarReceita((Receita) l);
            } else if (l instanceof Despesa) {
                controleFinanceiro.adicionarDespesa((Despesa) l);
            }
        }

        atualizarTabela();
        atualizarLabelsSaldo();
    }

    /**
     * Método salvarDados salva os dados da interface no csv
     */
    private void salvarDados() {
        repositorio.salvarTodos(controleFinanceiro.listarLancamentos());
    }

    /**
     * Método abrirDialogReceita abre a JanelaReceita 
     */
    private void abrirDialogReceita() {
        JanelaReceita dialog = new JanelaReceita(this);
        dialog.setVisible(true);

        Receita receita = dialog.getReceitaCriada();
        if (receita != null) {
            controleFinanceiro.adicionarReceita(receita);
            salvarDados();
            atualizarTabela();
            atualizarLabelsSaldo();
        }
    }

    /**
     * Método abrirDialogDespesa abre a JanelaDespesa
     */
    private void abrirDialogDespesa() {
        JanelaDespesa dialog = new JanelaDespesa(this);
        dialog.setVisible(true);

        Despesa despesa = dialog.getDespesaCriada();
        if (despesa != null) {
            controleFinanceiro.adicionarDespesa(despesa);
            salvarDados();
            atualizarTabela();
            atualizarLabelsSaldo();
        }
    }

    /**
     * Método removerLancamentosSelecionado faz a exclusão do lancamento selecionado na interface do array lancamentos
     */
    private void removerLancamentoSelecionado() {
        int linha = tabelaLancamentos.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um lançamento para remover.");
            return;
        }

        Lancamento selecionado = tableModel.getLancamentoNaLinha(linha);
        controleFinanceiro.removerLancamento(selecionado);

        salvarDados();
        atualizarTabela();
        atualizarLabelsSaldo();
    }

    /**
     * Método exibirExtrato exibe o extrato ordenado por data em uma nova janela
     */
    private void exibirExtrato() {
        List<ExtratoItem> extrato = controleFinanceiro.obterExtratoOrdenado();
        StringBuilder texto = new StringBuilder();

        for (ExtratoItem item : extrato) {
            texto.append(item.getData())
                 .append("  |  ")
                 .append(item.getDescricao())
                 .append("  |  R$ ")
                 .append(String.format("%.2f", item.getValor()))
                 .append("  |  Saldo: R$ ")
                 .append(String.format("%.2f", item.getSaldoAcumulado()))
                 .append(System.lineSeparator());
        }

        JTextArea area = new JTextArea(texto.toString(), 15, 40);
        area.setEditable(false);

        JOptionPane.showMessageDialog(this, new JScrollPane(area), "Extrato", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Método atualizarTabela atualiza a interface através do array de lancamentos
     */
    private void atualizarTabela() {
        tableModel.atualizarDados(controleFinanceiro.listarLancamentos());
    }

    /**
     * Método atualiarLabelsSaldo atualiza o campo de saldo
     */
    private void atualizarLabelsSaldo() {
        lblSaldoAtual.setText(String.format("Saldo Atual: R$ %.2f", controleFinanceiro.consultarSaldoAtual()));
    }
}
