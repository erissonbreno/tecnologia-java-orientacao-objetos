package br.edu.infnet.model.domain;

public abstract class Produto {
    private final String nome;
    private final double valor;
    private final int codigo;

    public Produto(String nome, double valor, int codigo) {
        this.nome = nome;
        this.valor = valor;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public abstract double calculaDesconto();
    public abstract double calculaPreco();

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", codigo=" + codigo +
                '}';
    }
}
