package com.caue;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaPrincipal extends JFrame {

    private ControleFinanceiro controleFinanceiro;
    private LancamentoRepositorio repositorio;

    private JTable tabelaLancamentos;
    private LancamentoTableModel tableModel;
    private JLabel lblSaldoAtual;
    private JLabel lblSaldoTotal;
    private JButton btnAdicionarReceita;
    private JButton btnAdicionarDespesa;
    private JButton btnRemover;
    private JButton btnExtrato;

    public TelaPrincipal(LancamentoRepositorio repositorio) {
        super("Controle Financeiro");
        this.repositorio = repositorio;
        this.controleFinanceiro = new ControleFinanceiro();

        initComponents();
        montarLayout();
        configurarEventos();
        carregarDadosIniciais(); // <-- requisito: resgatar dados do CSV ao iniciar

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 450);
        setLocationRelativeTo(null);
    }

    // -------------------------------------------------------------------------
    // Inicialização da interface
    // -------------------------------------------------------------------------
    private void initComponents() {
        tableModel        = new LancamentoTableModel(controleFinanceiro.listarLancamentos());
        tabelaLancamentos  = new JTable(tableModel);

        lblSaldoAtual = new JLabel("Saldo Atual: R$ 0,00");
        lblSaldoTotal = new JLabel("Saldo Total: R$ 0,00");

        btnAdicionarReceita = new JButton("Nova Receita");
        btnAdicionarDespesa = new JButton("Nova Despesa");
        btnRemover = new JButton("Remover Selecionado");
        btnExtrato = new JButton("Ver Extrato");
    }

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

    private void configurarEventos() {
        btnAdicionarReceita.addActionListener(e -> abrirDialogReceita());
        btnAdicionarDespesa.addActionListener(e -> abrirDialogDespesa());
        btnRemover.addActionListener(e -> removerLancamentoSelecionado());
        btnExtrato.addActionListener(e -> exibirExtrato());
    }

    // -------------------------------------------------------------------------
    // Carregamento e persistência de dados (CSV)
    // -------------------------------------------------------------------------
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

    private void salvarDados() {
        repositorio.salvarTodos(controleFinanceiro.listarLancamentos());
    }

    // -------------------------------------------------------------------------
    // Ações da interface
    // -------------------------------------------------------------------------
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

        JOptionPane.showMessageDialog(this, new JScrollPane(area),
                "Extrato", JOptionPane.PLAIN_MESSAGE);
    }

    // -------------------------------------------------------------------------
    // Atualização visual
    // -------------------------------------------------------------------------
    private void atualizarTabela() {
        tableModel.atualizarDados(controleFinanceiro.listarLancamentos());
    }

    private void atualizarLabelsSaldo() {
        lblSaldoAtual.setText(String.format("Saldo Atual: R$ %.2f", controleFinanceiro.consultarSaldoAtual()));
        lblSaldoTotal.setText(String.format("Saldo Total: R$ %.2f", controleFinanceiro.consultarSaldoTotal()));
    }
}
