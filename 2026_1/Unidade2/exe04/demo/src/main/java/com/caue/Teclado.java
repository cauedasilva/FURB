package com.caue;

import java.util.Scanner;

public class Teclado {
    private Scanner scanner;

    public Teclado() {
        this.scanner = new Scanner(System.in);
    }

    public int lerInt() {
        return scanner.nextInt();
    }

    public double lerDouble() {
        return scanner.nextDouble();
    }

    public boolean lerBoolean() {
        return scanner.nextBoolean();
    }

    public String lerString() {
        return scanner.next();
    }
}
