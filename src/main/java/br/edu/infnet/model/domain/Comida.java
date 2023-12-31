package br.edu.infnet.model.domain;

import br.edu.infnet.model.exceptions.PesoNegativoException;

import java.util.Arrays;

public class Comida extends Produto{
    private final double pesoEmKg;
    private final boolean vegano;
    private final String[] ingredientes;

    public Comida(String nome, double valor, int codigo, double pesoEmKg, boolean vegano, String[] ingredientes) throws PesoNegativoException {
        super(nome, valor, codigo);

        if(pesoEmKg <= 0) {
            throw new PesoNegativoException("O peso deve ser positivo.");
        }

        this.pesoEmKg = pesoEmKg;
        this.vegano = vegano;
        this.ingredientes = ingredientes;
    }

    public double getPesoEmKg() {
        return pesoEmKg;
    }

    public boolean isVegano() {
        return vegano;
    }

    @Override
    public double calculaDesconto() {
        if(isVegano() && getPesoEmKg() >= 1) {
            return (getValor() * getPesoEmKg()) * 0.2;
        }
        return 0;
    }

    @Override
    public double calculaPreco() {
        return  (getValor() * getPesoEmKg())- calculaDesconto();
    }

    @Override
    public String toString() {
        return "Comida{" +
                "peso=" + pesoEmKg +
                ", vegano=" + vegano +
                ", ingredientes='" + Arrays.toString(ingredientes) + '\'' +
                '}';
    }
}
