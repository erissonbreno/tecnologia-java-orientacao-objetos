package br.edu.infnet.model.domain;

import br.edu.infnet.model.exceptions.QuantidadeSobremesaZeroException;

import java.util.Set;

public class Sobremesa extends Produto {
    private int quantidade;
    private boolean doce;
    private Set<String> informacao;

    public Sobremesa(String nome, double valor, int codigo, int quantidade, boolean doce, Set<String> informacao) throws QuantidadeSobremesaZeroException {
        super(nome, valor, codigo);

        if (quantidade == 0) {
            throw new QuantidadeSobremesaZeroException("A quantidade de sobremesa nao pode ser 0");
        }

        this.quantidade = quantidade;
        this.doce = doce;
        this.informacao = informacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public double calculaDesconto() {
        if (getQuantidade() >= 2) {
            return (getValor() * getQuantidade()) * 0.05;
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
