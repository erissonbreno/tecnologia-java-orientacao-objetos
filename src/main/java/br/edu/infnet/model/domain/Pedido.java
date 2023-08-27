package br.edu.infnet.model.domain;

import br.edu.infnet.model.enums.TipoEntrega;

import java.util.List;
import java.util.stream.Collectors;

public class Pedido {
    private List<Produto> produtos;
    private TipoEntrega tipoEntrega;
    private boolean app;
    private Cliente cliente;

    public Pedido(List<Produto> produtos, TipoEntrega tipoEntrega, boolean app, Cliente cliente) {
        this.produtos = produtos;
        this.tipoEntrega = tipoEntrega;
        this.app = app;
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public boolean isApp() {
        return app;
    }

    public void setApp(boolean app) {
        this.app = app;
    }

    public double calcularValorPedido() {
        return getProdutos().stream()
                .mapToDouble(Produto::calculaPreco)
                .sum() + calcularTaxaEntrega();
    }

    private double calcularTaxaEntrega() {
        if (isApp()) {
            this.tipoEntrega = TipoEntrega.RAPIDA;
        } else {
            if (getTipoEntrega().equals(TipoEntrega.RAPIDA)) {
                return 5.00;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        List<String> produtos = getProdutos().stream()
                .map(prod ->
                        "\n    Produto: " + prod.getNome() +
                                "\n    Codigo: " + prod.getCodigo() +
                                "\n    Preco: " + prod.calculaPreco() + "\n")
                .collect(Collectors.toList());

        return "\n########################Pedido########################" +
                "\nInformacoes do cliente:" +
                "\n--Nome: " + cliente.getNome() +
                "\n--Email: " + cliente.getEmail() +
                "\n--CPF: " + cliente.getCpf() +
                "\nInformacoes do produto:" +
                produtos +
                "\nAplicativo: " + app +
                "\nTipo de Entrega: " + getTipoEntrega() +
                "\nTaxa de Entrega: R$ " + calcularTaxaEntrega() +
                "\nValor total: R$" + calcularValorPedido();
    }
}
