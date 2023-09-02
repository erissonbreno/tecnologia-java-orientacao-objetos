import br.edu.infnet.model.domain.Bebida;
import br.edu.infnet.model.enums.TamanhoBebida;
import br.edu.infnet.model.exceptions.BebidaGeladaPequenaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BebidaTest {

    @Test
    public void testBebidaGeladaDeveSerGrande() {
        BebidaGeladaPequenaException thrown = assertThrows(BebidaGeladaPequenaException.class, () ->
                new Bebida("BebidaTest", 10, 123, true, TamanhoBebida.LATA, "Test"));
        assertEquals(thrown.getMessage(), "A bebida para ser gelada deve ser tamanho 2L");
    }

    @Test
    public void testBebidaGrandeDeveTerDezPorcentoDeDesconto() throws BebidaGeladaPequenaException {
        Bebida bebidaGrande = new Bebida("BebidaTest", 10, 123, true, TamanhoBebida.GARRAFA_2L, "Test");
        assertEquals(bebidaGrande.calculaPreco(), 9);
    }
}
