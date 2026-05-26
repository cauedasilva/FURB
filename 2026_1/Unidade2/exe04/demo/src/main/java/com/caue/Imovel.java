package com.caue;

public class Imovel {
    private String endereco;
    private int area;
    private Bairro bairro;
    private Finalidade finalidade;

    /**
     * @param endereco  
     * @param area
     * @param bairro
     * @param finalidade
     */

    public Finalidade getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(Finalidade finalidade) {
        if (finalidade == null) {
            throw new IllegalArgumentException("Finalidade inválida");
        }
        this.finalidade = finalidade;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        if (bairro == null) {
            throw new IllegalArgumentException("Bairro inválido");
        }
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getArea() {
        return area;
    }
    
    public void setArea(int area) {
        if (area <= 0) {
            throw new IllegalArgumentException("O valor precisa ser maior que 0");
        }

        this.area = area;

    }

    public Imovel(int area, String endereco) {
        setArea(area);
        setEndereco(endereco);
    }

    public double calcularIptu() {
        double area = getArea();
        double coeficienteIptu = bairro.getCoeficienteIptu();
    
        switch (getFinalidade()) {
            case RESIDENCIAL:
                return area * coeficienteIptu;
            case COMERCIAL:
                if (area <= 100) {
                    return 500 * coeficienteIptu;
                } else if (area >= 101 && area <= 400) {
                    return 1000 * coeficienteIptu;
                } else {
                    return area * 2.55;
                }
            case INDUSTRIAL:
                if (area <= 2000) {
                    return 1000;
                } else {
                    return area * 0.55;
                }
            default:
                throw new IllegalArgumentException("É necessário existir uma finalidade para o imóvel");
        }
    }

    /**
     * @return Retorna o valor do IPTU
     */
    
}
