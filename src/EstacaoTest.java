
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Os testes prontos servem de exemplo.
 * Complete os testes marcados com //TODO (Tarefas 4 e 5).
 */
public class EstacaoTest {

    private Estacao estacao;

    @BeforeEach
    void setUp() {
        estacao = new Estacao("E1");
    }

    @Test
    void deveAdicionarPatineteNovo() {
        Patinete p = new Patinete("1234", 80);
        assertTrue(estacao.adicionar(p), "deveria adicionar");
        assertEquals(1, estacao.totalPatinetes());
    }

    @Test
    void naoDeveAdicionarCodigoDuplicado() {
        assertTrue(estacao.adicionar(new Patinete("1234", 80)));
        assertFalse(estacao.adicionar(new Patinete("1234", 50)),
                "codigo duplicado deve ser rejeitado");
        assertEquals(1, estacao.totalPatinetes());
    }

    @Test
    void deveContarDisponiveisEEmUso() {
        estacao.adicionar(new Patinete("1111", 80));
        estacao.adicionar(new Patinete("2222", 10));
        Patinete emUso = new Patinete("3333", 90);
        estacao.adicionar(emUso);
        emUso.iniciarAluguel();
        assertEquals(1, estacao.totalDisponiveis());
        assertEquals(1, estacao.totalEmUso());
    }

    @Test
    void resumoDeveConterCodigoETotais() {
        estacao.adicionar(new Patinete("1234", 80));
        String r = estacao.resumo();
        assertTrue(r.contains("E1"), r);
        assertTrue(r.contains("total=1"), r);
        assertTrue(r.contains("disp=1"), r);
        assertTrue(r.contains("uso=0"), r);
    }

    @Test
    void deveCalcularAproveitamentoFrota() {
        estacao.adicionar(new Patinete("1111", 80));
        estacao.adicionar(new Patinete("2222", 80));
        Patinete p3 = new Patinete("2222", 80);
        Double aproveitamento = estacao.aproveitamentoFrota();
        assertEquals(0, aproveitamento, 0.01d);

        p3.iniciarAluguel();
        assertEquals(0.33, aproveitamento, 0.01d);
        
        

    }

    @Test
    void deveCompararEstacoes() {
        Estacao estacao2 = new Estacao("E2");
        estacao.adicionar(new Patinete("1111", 80));
        estacao.adicionar(new Patinete("2222", 80));
        estacao2.adicionar(new Patinete("3333", 80));
        estacao2.adicionar(new Patinete("4444", 80));
        boolean isNafrente = estacao.estaNaFrenteDe(estacao2);
        assertTrue(isNafrente);
    }
}
