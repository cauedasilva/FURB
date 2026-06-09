package com.example;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {
    public static void main(String[] args) {
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Selecione um arquivo csv", "csv");
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(filtro);
        int resposta = chooser.showDialog(null, "Confirmar");
        if (resposta == JFileChooser.APPROVE_OPTION) {
            File selecionado = chooser.getSelectedFile();
            ImportarArquivo importar = new ImportarArquivo(selecionado);
            Municipio maior = importar.getMaiorPopulacao();
            System.out.println("Maior populacao" + maior.getNome() + " " + maior.getPopulacao());
            Municipio menor = importar.getMenorPopulacao();
            System.out.println("menor populacao" + menor.getNome() + " " + menor.getPopulacao());
        }
    }
}