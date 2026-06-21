package com.caue;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

// Faz a "ponte" entre a lista de objetos Lancamento (modelo de domínio)
// e a JTable do Swing, que só entende linhas/colunas de texto.
public class LancamentoTableModel extends AbstractTableModel {

    private List<Lancamento> lancamentos;
    private final String[] colunas = {"Tipo", "Descrição", "Valor", "Data", "Categoria"};

    public LancamentoTableModel(List<Lancamento> lancamentos) {
        this.lancamentos = new ArrayList<>(lancamentos);
    }

    // -------------------------------------------------------------------------
    // Métodos obrigatórios de AbstractTableModel
    // -------------------------------------------------------------------------
    @Override
    public int getRowCount() {
        return lancamentos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lancamento l = lancamentos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return (l instanceof Receita) ? "Receita" : "Despesa";
            case 1:
                return l.getDescricao();
            case 2:
                return String.format("%.2f", l.getValor());
            case 3:
                return l.getData().toString();
            case 4:
                if (l instanceof Receita) {
                    return ((Receita) l).getCategoriaReceita().toString();
                } else if (l instanceof Despesa) {
                    return ((Despesa) l).getCategoriaDespesa().toString();
                }
                return "";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    // -------------------------------------------------------------------------
    // Auxiliares
    // -------------------------------------------------------------------------
    public void atualizarDados(List<Lancamento> novosLancamentos) {
        this.lancamentos = new ArrayList<>(novosLancamentos);
        fireTableDataChanged();
    }

    public Lancamento getLancamentoNaLinha(int rowIndex) {
        return lancamentos.get(rowIndex);
    }
}
