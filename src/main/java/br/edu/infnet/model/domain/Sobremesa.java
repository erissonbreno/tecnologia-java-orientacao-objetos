package br.edu.infnet.model.domain;

import br.edu.infnet.model.exceptions.QuantidadeSobremesaZeroException;

import java.util.Set;

public class Sobremesa extends Produto {
    private int quantidade;
    private boolean doce;
    private Set<String> informacao;

    public Sobremesa(String nome, double valor, int codigo, int quantidade, boolean doce, Set<String> informacao) throws QuantidadeSobremesaZeroException {
        super(nome, valor, codigo);

        if(quantidade == 0) {
            throw new QuantidadeSobremesaZeroException("A quantidade de sobremesa não pode ser 0");
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

    public Set<String> getInformacao() {
        return informacao;
    }

    public void setInformacao(Set<String> informacao) {
        this.informacao = informacao;
    }

    @Override
    public double calculaDesconto() {
        if (getQuantidade() >= 2) {
            return getValor() * 0.05;
        }
        return 0;
    }

    @Override
    public double calculaPreco() {
        return (getValor() * getQuantidade()) - calculaDesconto();
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
