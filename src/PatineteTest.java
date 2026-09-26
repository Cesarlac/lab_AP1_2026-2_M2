
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PatineteTest {

    @Test
    void iniciaDisponivelComBateriaSuficiente() {
        Patinete p = new Patinete("1234", 80);
        assertEquals("disponivel", p.estado());
    }

    @Test
    void iniciaIndisponivelComBateriaBaixa() {
        Patinete p = new Patinete("1234", 10);
        assertEquals("indisponivel", p.estado());
    }

    @Test
    void aluguelAlteraEstado() {
        Patinete p = new Patinete("1234", 50);
        assertTrue(p.iniciarAluguel());
        assertEquals("em_uso", p.estado());
        assertTrue(p.encerrarAluguel());
        assertEquals("disponivel", p.estado());
    }

    @Test
    void codigoInvalidoVira0000() {
        Patinete p = new Patinete("12", 50);
        assertEquals("0000", p.getCodigo());
    }

}
