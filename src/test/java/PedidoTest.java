import br.edu.infnet.model.domain.Bebida;
import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.domain.Comida;
import br.edu.infnet.model.domain.Pedido;
import br.edu.infnet.model.enums.TamanhoBebida;
import br.edu.infnet.model.enums.TipoEntrega;
import br.edu.infnet.model.exceptions.BebidaGeladaPequenaException;
import br.edu.infnet.model.exceptions.DadosPessoaisNulosException;
import br.edu.infnet.model.exceptions.PesoNegativoException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {
    Bebida cervejaLata = new Bebida("Cerveja Lata", 3.00, 1002, false, TamanhoBebida.LATA, "Budweiser");
    Comida hamburguer = new Comida("Hamburguer", 20.50, 1003, 0.5, false, new String[]{"Carne", "Sal"});
    Cliente joao = new Cliente("Joao", "j@a", "111");

    public PedidoTest() throws BebidaGeladaPequenaException, PesoNegativoException, DadosPessoaisNulosException {
    }

    @Test
    public void testValorPedidoDeveSerSomaDosValoresDosProdutosMaisTaxaDeEntrega() {
        Pedido pedidoEntregaRapida = new Pedido(List.of(cervejaLata, hamburguer),
                TipoEntrega.RAPIDA, false, joao);

        assertEquals(pedidoEntregaRapida.calcularValorPedido(), 3 + 10.25 + 5);
    }

    @Test
    public void testTaxaDeEntregaDeveSerGratuitaParaAplicativo() {
        Pedido pedidoAplicativo = new Pedido(List.of(cervejaLata, hamburguer),
                TipoEntrega.RAPIDA, true, joao);
        assertEquals(pedidoAplicativo.calcularTaxaEntrega(), 0);
    }

    @Test
    public void testTipoDeEntregaDeveSerRapidaParaAplicativo() {
        Pedido pedidoAplicativo = new Pedido(List.of(cervejaLata, hamburguer),
                TipoEntrega.NORMAL, true, joao);
        assertEquals(pedidoAplicativo.getTipoEntrega(), TipoEntrega.RAPIDA);
    }

    @Test
    public void testTaxaDeEntregaDeveSerCincoReaisParaEntregaRapidaNaoFeitaPorAplicativo() {
        Pedido pedidoNaoAplicativo = new Pedido(List.of(cervejaLata, hamburguer),
                TipoEntrega.RAPIDA, false, joao);

        assertEquals(pedidoNaoAplicativo.calcularTaxaEntrega(), 5);
    }
}
