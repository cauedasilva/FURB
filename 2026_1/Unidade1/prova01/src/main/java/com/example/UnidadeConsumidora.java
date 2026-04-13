package com.example;

public class UnidadeConsumidora {
    private int identificador;
    private Categoria categoria;
    private int kWhMes;

    /**
     * Método getter para o atributo identificador 
     * @return um int do identificador
     */

    public int getIdentificador() {
        return identificador;
    }

    /**
     * Método setter para o atributo identificador 
     * @param identificador identificador a ser utilizado
     */

    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("identificador invalido");
        }
        this.identificador = identificador;
    }

    /**
     * Método getter para o atributo categoria 
     * @return o enum Categoria da instância da unidade consumidora
     */

    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Método setter para o atributo categoria 
     * @param categoria categoria a ser utilizada
     */

    public void setCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("categoria invalido");
        }
        this.categoria = categoria;
    }

    /**
     * Método getter para o atributo kWhMes 
     * @return um int kWhMes
     */

    public int getkWhMes() {
        return kWhMes;
    }

    /**
     * Método setter para o atributo kWhMes 
     * @param kWhMes kWhMes a ser utilizado
     */

    public void setkWhMes(int kWhMes) {
        if (kWhMes <= 0) {
            throw new IllegalArgumentException("kWhMes invalido");
        }
        this.kWhMes = kWhMes;
    }

    /**
     * Método constructor da classe UnidadeConsumidora
     * @param identificador identificador a ser utilizado
     * @param categoria categoria a ser utilizada
     * @param kWhMes kWhMes a ser utilizado 
     */

    public UnidadeConsumidora(int identificador, Categoria categoria, int kWhMes) {
        setIdentificador(identificador);
        setCategoria(categoria);
        setkWhMes(kWhMes);
    }

    /**
     * Método calcularFatura calcula o valor da fatura 
     * @return um valor double de acordo com a categoria e consumo da unidade consumidora
     */

    public double calcularFatura() {
        double kWhMes = getkWhMes();

        switch (getCategoria()) {
            case RESIDENCIAL:
                if (kWhMes > 200) {
                    double excedente = kWhMes - 200;
                    double valorBase = 200 * 0.5;
                    return (excedente * 0.75) + valorBase;
                }
                return kWhMes * 0.5;
            case COMERCIAL: 
                if (kWhMes > 800) {
                    double excedente = kWhMes - 800;
                    double valorBase = 800 * 0.75;
                    return (excedente * 1) + valorBase;
                }
                return kWhMes * 0.75;
            case INDUSTRIAL:
                return kWhMes * 0.85;
            default:
                throw new IllegalArgumentException("finalidade invalido");
        }
    }
}
