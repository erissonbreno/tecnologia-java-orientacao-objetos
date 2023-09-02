package br.edu.infnet.model.domain;

import br.edu.infnet.model.enums.TamanhoBebida;
import br.edu.infnet.model.exceptions.BebidaGeladaPequenaException;

public class Bebida extends Produto{
    private final boolean gelada;
    private final TamanhoBebida tamanho;
    private final String marca;

    public Bebida(String nome, double valor, int codigo, boolean gelada, TamanhoBebida tamanho, String marca) throws BebidaGeladaPequenaException {
        super(nome, valor, codigo);

        if(gelada && (tamanho != TamanhoBebida.GARRAFA_2L)) {
            throw new BebidaGeladaPequenaException("A bebida para ser gelada deve ser tamanho 2L");
        }
        this.gelada = gelada;
        this.tamanho = tamanho;
        this.marca = marca;
    }

    @Override
    public double calculaDesconto() {
        if(getTamanho().equals(TamanhoBebida.GARRAFA_2L)) {
            return getValor() * 0.1;
        }
        return 0.00;
    }

    @Override
    public double calculaPreco() {
        return getValor() - calculaDesconto();
    }

    public TamanhoBebida getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "gelada=" + gelada +
                ", tamanho=" + tamanho +
                ", marca='" + marca + '\'' +
                '}';
    }
}


