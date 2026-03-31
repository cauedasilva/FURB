package com.caue;

public class Main {
    public static void main(String[] args) {
        Bairro centro = new Bairro("Centro", 1.2);

        Imovel imovel = new Imovel(420, "Teste");

        imovel.setBairro(centro);
        imovel.setFinalidade(Finalidade.INDUSTRIAL);

        double valorIptu = imovel.calcularIptu();
        System.out.println("IPTU do imóvel no " + imovel.getBairro().getNome() + ": R$ " + valorIptu);
    }
}