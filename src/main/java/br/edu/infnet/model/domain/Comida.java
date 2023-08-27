package br.edu.infnet.model.domain;

public class Comida extends Produto{
    private double peso;
    private boolean vegano;
    private String ingredientes;

    public Comida(String nome, double valor, int codigo, double peso, boolean vegano, String ingredientes) {
        super(nome, valor, codigo);
        this.peso = peso;
        this.vegano = vegano;
        this.ingredientes = ingredientes;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public double calculaDesconto() {
        if(isVegano() && getPeso() >= 1) {
            return getValor() * 0.2;
        }
        return 0;
    }

    @Override
    public double calculaPreco() {
        return  getValor()- calculaDesconto();
    }

    @Override
    public String toString() {
        return "Comida{" +
                "peso=" + peso +
                ", vegano=" + vegano +
                ", ingredientes='" + ingredientes + '\'' +
                '}';
    }
}
