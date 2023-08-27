package br.edu.infnet.model.domain;

import br.edu.infnet.model.enums.TamanhoBebida;
import br.edu.infnet.model.exceptions.BebidaGeladaPequenaException;

public class Bebida extends Produto{
    private boolean gelada;
    private TamanhoBebida tamanho;
    private String marca;

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

    public boolean isGelada() {
        return gelada;
    }

    public void setGelada(boolean gelada) {
        this.gelada = gelada;
    }

    public TamanhoBebida getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoBebida tamanho) {
        this.tamanho = tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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


