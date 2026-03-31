package com.caue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ImovelTest {
    @Test
    void testSetArea() {
        String mensagemEsperada = "O valor precisa ser maior que 0";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
           new Imovel(-5, "teste");
        });
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    void testArea() {
        String mensagemEsperada = "O valor precisa ser maior que 0";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Bairro bairro = new Bairro("Centro", 1);
            Imovel imovel =  new Imovel(0, "teste");
            imovel.setBairro(bairro);
            imovel.calcularIptu();
        });
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    void testEndereco() {
        Bairro bairro = new Bairro("Centro", 1);
        Imovel imovel =  new Imovel(250, "teste");
        imovel.setBairro(bairro);
        String mensagemEsperada = "É necessário existir uma finalidade para o imóvel";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            imovel.calcularIptu();
        });
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    void testBairro() {
        Imovel imovel =  new Imovel(400, "teste");
        imovel.setFinalidade(Finalidade.RESIDENCIAL);
        String mensagemEsperada = "Bairro inválido";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            imovel.setBairro(null);
        });
        assertEquals(mensagemEsperada, exception.getMessage());
    }

    @Test
    void testCalcularIptu() {
        Imovel imovel = new Imovel(400, "teste");
        Bairro bairro = new Bairro("teste", 1);
        imovel.setBairro(bairro);
        imovel.setFinalidade(Finalidade.RESIDENCIAL);
        assertEquals(400, imovel.calcularIptu(), 0.1);

        Imovel imovel2 = new Imovel(80, "teste");
        Bairro bairro2 = new Bairro("teste", 1);
        imovel2.setBairro(bairro2);
        imovel2.setFinalidade(Finalidade.COMERCIAL);
        assertEquals(500, imovel2.calcularIptu(), 0.1);

        Imovel imovel3 = new Imovel(250, "teste");
        Bairro bairro3 = new Bairro("teste", 1);
        imovel3.setBairro(bairro3);
        imovel3.setFinalidade(Finalidade.COMERCIAL);
        assertEquals(1000, imovel3.calcularIptu(), 0.1);

        Imovel imovel4 = new Imovel(500, "teste");
        Bairro bairro4 = new Bairro("teste", 1);
        imovel4.setBairro(bairro4);
        imovel4.setFinalidade(Finalidade.COMERCIAL);
        assertEquals(1275, imovel4.calcularIptu(), 0.1);

        Imovel imovel5 = new Imovel(2000, "teste");
        Bairro bairro5 = new Bairro("teste", 1);
        imovel5.setBairro(bairro5);
        imovel5.setFinalidade(Finalidade.INDUSTRIAL);
        assertEquals(1000, imovel5.calcularIptu(), 0.1);

        Imovel imovel6 = new Imovel(3000, "teste");
        Bairro bairro6 = new Bairro("teste", 1);
        imovel6.setBairro(bairro6);
        imovel6.setFinalidade(Finalidade.INDUSTRIAL);
        assertEquals(1650, imovel6.calcularIptu(), 0.1);

        Imovel imovel7 = new Imovel(500, "teste");
        Bairro bairro7 = new Bairro("teste", 2.5);
        imovel7.setBairro(bairro7);
        imovel7.setFinalidade(Finalidade.RESIDENCIAL);
        assertEquals(1250, imovel7.calcularIptu(), 0.1);
    }
}
