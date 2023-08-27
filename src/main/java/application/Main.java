package application;

import br.edu.infnet.model.domain.*;
import br.edu.infnet.model.enums.TamanhoBebida;
import br.edu.infnet.model.enums.TipoEntrega;
import br.edu.infnet.model.exceptions.QuantidadeSobremesaInvalidaException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws QuantidadeSobremesaInvalidaException {
        Cliente breno = new Cliente("Breno", "e@b.com", "123");

        Bebida cocaColaGrande = new Bebida("Refrigerante 2L", 8.00, 1001, true, TamanhoBebida.GARRAFA_2L, "Coca-Cola");
        Bebida cervejaLata = new Bebida("Cerveja Lata", 3.00, 1002, true, TamanhoBebida.LATA, "Budweiser");

        Comida hamburguer = new Comida("Hamburguer", 20.50, 1003, 0.8, false, "Carne");
        Comida feijao = new Comida("Feijao", 7.50, 1004, 1, true, "Feijao");

        Sobremesa mousseDeMaracuja = new Sobremesa("Mousse de Maracuja", 9.00, 1006, 2, true, "Contem acucar");
        Sobremesa mousseFit = new Sobremesa("Mousse Whey", 13.90, 1007, 1, false, "Fitness");
//        Sobremesa sobremesaNula = new Sobremesa("Inexistente", 20, 1007, 0, false, "");

        Pedido pedidoSoBebida = new Pedido(List.of(cocaColaGrande, cervejaLata), TipoEntrega.RAPIDA, true, breno);
        Pedido pedidoCompletoEntregaRapida = new Pedido(List.of(cocaColaGrande, cervejaLata, hamburguer, feijao, mousseFit, mousseDeMaracuja),
                TipoEntrega.RAPIDA, false, breno);
        Pedido pedidoCompletoEntregaNormal = new Pedido(List.of(cocaColaGrande, cervejaLata, hamburguer, feijao, mousseFit, mousseDeMaracuja),
                TipoEntrega.NORMAL, false, breno);
//        Pedido pedidoSobremesaNula = new Pedido(List.of(cocaColaGrande, cervejaLata, sobremesaNula),
//                TipoEntrega.NORMAL, false, breno);

        System.out.println(pedidoSoBebida);
        System.out.println(pedidoCompletoEntregaRapida);
        System.out.println(pedidoCompletoEntregaNormal);
        }
}