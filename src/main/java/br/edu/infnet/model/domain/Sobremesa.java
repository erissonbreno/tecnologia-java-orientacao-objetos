package br.edu.infnet.model.domain;

import br.edu.infnet.model.exceptions.QuantidadeSobremesaInvalidaException;

public class Sobremesa extends Produto {
    private int quantidade;
    private boolean doce;
    private String informacao;

    public Sobremesa(String nome, double valor, int codigo, int quantidade, boolean doce, String informacao) throws QuantidadeSobremesaInvalidaException {
        super(nome, valor, codigo);

        if(quantidade == 0) {
            throw new QuantidadeSobremesaInvalidaException("A quantidade de sobremesa não pode ser 0");
        }

        this.quantidade = quantidade;
        this.doce = doce;
        this.informacao = informacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDoce() {
        return doce;
    }

    public void setDoce(boolean doce) {
        this.doce = doce;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    @Override
    public double calculaDesconto() {
        if (isDescontoElegivel()) {
            return getValor() * 0.05;
        }
        return 0;
    }

    @Override
    public double calculaPreco() {
        return (getValor() * getQuantidade()) - calculaDesconto();
    }

    private boolean isDescontoElegivel() {
        return getQuantidade() >= 2;
    }

    @Override
    public String toString() {
        return "Sobremesa{" +
                "quantidade=" + quantidade +
                ", doce=" + doce +
                ", informacao='" + informacao + '\'' +
                '}';
    }
}