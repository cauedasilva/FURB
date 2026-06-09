package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ArquivoMp3 {
    private tagMp3 tag;

    private String lerBytes(byte[] bytes, int inicio, int qtdBytes) {
        byte[] leitura = new byte[qtdBytes];
        for (int i = 0; i < qtdBytes; i++) {
            leitura[i] = bytes[inicio + i];
        }

        return new String(leitura);
    }

    private void importarArquivo(File arquivo) {
        byte[] cabecalho = new byte[128];
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            fis.skip(arquivo.length()-128)
            fis.read(cabecalho);
            fis.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String musica = lerBytes(cabecalho, 3, 30);
        String artista = lerBytes(cabecalho, 33, 30);
        String album = lerBytes(cabecalho, 63, 30);
        tag = new TagMp3();
        tag.setArtista(artista);
    }

    private arquivoMp3(File arquivo) throws FileNotFoundException {
        if (!arquivo.exists()) {
            throw new FileNotFoundException("Arquivo não encontrado");
            importarArquivo(arquivo);
        }
    }
}
