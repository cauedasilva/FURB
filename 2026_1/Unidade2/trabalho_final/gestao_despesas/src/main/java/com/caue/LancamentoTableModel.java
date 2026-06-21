package com.caue;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class LancamentoTableModel extends AbstractTableModel {
    private ArrayList<Lancamento> lancamentos;
    private String[] colunas = {"Tipo", "Descrição", "Valor", "Data", "Categoria"};

    /**
     * Método constructor da classe LancamentoTableModel 
     * @param lancamentos array lancamentos a ser adicionado
     */
    public LancamentoTableModel(ArrayList<Lancamento> lancamentos) {
        this.lancamentos = new ArrayList<>(lancamentos);
    }

    /**
     * Método obrigatório da classe AbstractTableModel
     * @return tamanho do array lancamentos
     */
    @Override
    public int getRowCount() {
        return lancamentos.size();
    }

    /**
     * Método obrigatório da classe AbstractTableModel
     * @return número de colunas definidas
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    /**
    * Método obrigatório da classe AbstractTableModel
    * Retorna o valor a ser exibido na célula da tabela a partir da linha (lançamento) e a coluna (atributo)
    * @param rowIndex índice da linha relativo à posição do lançamento na lista
    * @param columnIndex índice da coluna a ser exibida
    * @return o valor da célula como objeto ou nulo se a coluna não existir
    */
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

    /**
     * Método atualizarDados atualiza os novos lancamentos adicionados pela interface
     * @param novosLancamentos array atualizado de lancamentos
     */
    public void atualizarDados(ArrayList<Lancamento> novosLancamentos) {
        this.lancamentos = new ArrayList<>(novosLancamentos);
        fireTableDataChanged();
    }

    /**
     * Método getLancamentoNaLinha busca o lançamento na linha selecionada
     * @param rowIndex número da linha
     * @return objeto lancamento selecionado na linha
     */
    public Lancamento getLancamentoNaLinha(int rowIndex) {
        return lancamentos.get(rowIndex);
    }
}
