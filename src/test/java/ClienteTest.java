import br.edu.infnet.model.domain.Cliente;
import br.edu.infnet.model.exceptions.DadosPessoaisNulosException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteTest {

    @Test
    public void testNomeDeveSerPreenchido() {
        DadosPessoaisNulosException thrown = assertThrows(DadosPessoaisNulosException.class, () ->
                new Cliente("", "e@b", "123"));
        assertEquals(thrown.getMessage(), "Deve conter um nome.");
    }

    @Test
    public void testEmailDeveSerPreenchido() {
        DadosPessoaisNulosException thrown = assertThrows(DadosPessoaisNulosException.class, () ->
                new Cliente("Breno", "", "123"));
        assertEquals(thrown.getMessage(), "Deve conter um email.");
    }

    @Test
    public void testCPFDeveSerPreenchido() {
        DadosPessoaisNulosException thrown = assertThrows(DadosPessoaisNulosException.class, () ->
                new Cliente("Breno", "e@b", ""));
        assertEquals(thrown.getMessage(), "Deve conter um CPF.");
    }
}
