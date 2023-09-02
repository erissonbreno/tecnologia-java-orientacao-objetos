import br.edu.infnet.model.domain.Sobremesa;
import br.edu.infnet.model.exceptions.QuantidadeSobremesaZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SobremesaTest {

    @Test
    public void testQuantidadeSobremesaNaoPodeSerZero() {
        QuantidadeSobremesaZeroException thrown = assertThrows(QuantidadeSobremesaZeroException.class, () ->
                new Sobremesa("Mousse de Maracuja", 9.00, 1006, 0, true, Set.of("Contem acucar")));
        assertEquals(thrown.getMessage(), "A quantidade de sobremesa nao pode ser 0");
    }

    @Test
    public void testDescontoDeCincoPorcentoParaQuantidadeMaiorOuIgualADois() throws QuantidadeSobremesaZeroException {
        Sobremesa mousse = new Sobremesa("Mousse de Maracuja", 9.00, 1006, 2, true, Set.of("Contem acucar"));
        assertEquals(mousse.calculaPreco(), 17.10);
    }
}
