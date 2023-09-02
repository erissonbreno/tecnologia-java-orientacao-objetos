import br.edu.infnet.model.domain.Comida;
import br.edu.infnet.model.exceptions.PesoNegativoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComidaTest {

    @Test
    public void testPesoDaComidaDeveSerPositivo() {
        PesoNegativoException thrown = assertThrows(PesoNegativoException.class, () ->
                new Comida("Arroz", 5.00, 123, -1.00, true, new String[]{"Arroz"}));
        assertEquals(thrown.getMessage(), "O peso deve ser positivo.");
    }

    @Test
    public void testComidaVeganaEMaiorQueUmKgDeveTerDescontoDeVintePorcento() throws PesoNegativoException {
        Comida arroz = new Comida("Arroz", 5.00, 123, 2, true, new String[]{"Arroz"});
        assertEquals(arroz.calculaPreco(), 8);
    }

    @Test
    public void testPrecoComidaDeveSerCalculadoDeAcordoComOPeso() throws PesoNegativoException {
        Comida arroz = new Comida("Arroz", 5.00, 123, 0.5, true, new String[]{"Arroz"});
        assertEquals(arroz.calculaPreco(), 2.5);
    }
}
