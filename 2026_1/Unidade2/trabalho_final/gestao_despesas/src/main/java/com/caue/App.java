package com.caue;

import javax.swing.SwingUtilities;

public class App {
    private static String ARQUIVO_CSV = "lancamentos.csv";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LancamentoRepositorio repositorio = new LancamentoCsvRepositorio(ARQUIVO_CSV);
            TelaPrincipal tela = new TelaPrincipal(repositorio);
            tela.setVisible(true);
        });
    }
}
