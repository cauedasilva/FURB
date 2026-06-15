package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ImportarArquivo {
    ArrayList<Municipio> municipios = new ArrayList<>();

    public ImportarArquivo(File arquivo) {
        FileReader reader;
        try {
            reader = new FileReader(arquivo);
            BufferedReader buffer = new BufferedReader(reader);
            String linha = buffer.readLine();

            linha = buffer.readLine();

            while (linha != null) {
                linha = buffer.readLine();
                processaLinha(linha);
            }

            buffer.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
       
    }

    public void processaLinha(String linha) {
        String[] campos = linha.split(";");
        int codigo = Integer.parseInt(campos[0]);
        String municipio = campos[1];
        String estado = campos[2];
        int populacao = Integer.parseInt(campos[3]);
        Municipio m = new Municipio(codigo, municipio, estado, populacao);
    }

    public Municipio getMaiorPopulacao() {
        Municipio maior = municipios.get(0);
        for (Municipio m: municipios) {
            if (m.getPopulacao() > maior.getPopulacao()) {
                maior = m;
            }
        }

        return maior;
    }

    public Municipio getMenorPopulacao() {
        Municipio menor = municipios.get(0);
        for (Municipio m: municipios) {
            if (m.getPopulacao() < menor.getPopulacao()) {
                menor = m;
            }
        }

        return menor;
    }
}
