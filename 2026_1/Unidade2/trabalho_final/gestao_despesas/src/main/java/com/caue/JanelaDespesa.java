package com.caue;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class JanelaDespesa extends JDialog {
    private JTextField txtDescricao;
    private JTextField txtValor;
    private JTextField txtData;
    private JComboBox<CategoriaDespesa> cmbCategoria;
    private JButton btnSalvar;
    private JButton btnCancelar;
    private Despesa despesaCriada;

    /**
     * Método constructor da classe JanelaDespesa
     * @param parent modal que o Java Swing usa como referencia para posicionar a janela de diálogo em relação
     */
    public JanelaDespesa(JFrame parent) {
        super(parent, "Nova Despesa", true);
        carregarDados();
    }

    /**
     * Método carregarDados carrega todos os dados do modal/janela dialog, não os dados do csv
     */
    private void carregarDados() {
        setLayout(new GridLayout(5, 2, 8, 8));

        txtDescricao = new JTextField();
        txtValor = new JTextField();
        txtData = new JTextField(LocalDate.now().toString());
        cmbCategoria = new JComboBox<>(CategoriaDespesa.values());
        btnSalvar = new JButton("Salvar");
        btnCancelar = new JButton("Cancelar");

        add(new JLabel("Descrição:"));
        add(txtDescricao);
        add(new JLabel("Valor:"));
        add(txtValor);
        add(new JLabel("Data (Ano-Mês-Dia):"));
        add(txtData);
        add(new JLabel("Categoria:"));
        add(cmbCategoria);
        add(btnSalvar);
        add(btnCancelar);

        btnSalvar.addActionListener(e -> salvar());
        btnCancelar.addActionListener(e -> dispose());

        setSize(400, 240);
        setLocationRelativeTo(getParent());
    }

    /**
     * Método salvar salva os dados inseridos nos campos a janela em um objeto da classe Despesa
     */
    private void salvar() {
        if (!validarCampos()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Dados inválidos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String descricao = txtDescricao.getText().trim();
        double valor = Double.parseDouble(txtValor.getText().trim().replace(",", "."));
        LocalDate data = LocalDate.parse(txtData.getText().trim());
        CategoriaDespesa categoria = (CategoriaDespesa) cmbCategoria.getSelectedItem();

        despesaCriada = new Despesa(descricao, valor, data, categoria);
        dispose();
    }

    /**
     * Método validarCampos valida se todos os campos da janela estão preenchidos corretamente
     * @return boolean caso estão preenchidos corretamente ou não
     */
    private boolean validarCampos() {
        if (txtDescricao.getText().trim().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(txtValor.getText().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return false;
        }
        try {
            LocalDate.parse(txtData.getText().trim());
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    /**
     * Método getter do atributo despesaCriada
     * @return objeto criado a partir do modal
     */
    public Despesa getDespesaCriada() {
        return despesaCriada;
    }
}
