package com.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File();
        long tamanho = tamanhoArquivo(file);
    }

    public static long tamanhoArquivo(File file) {
        if (file.isFile()) {
            return file.length()
        }

        long total = 0;
        for (File filho: file.listFiles()) {
            total += tamanhoArquivo(filho);
        }

        return total;
     }
}