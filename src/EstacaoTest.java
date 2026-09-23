
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Complete os testes marcados com //TODO.
 */
public class EstacaoTest {

    private Estacao estacao;

    @BeforeEach
    void setUp() {
        estacao = new Estacao("E1");
    }

    @Test
    void deveAdicionarPatineteNovo() {
        //TODO: Arrange com Patinete disponivel; Act adicionar; Assert true e total==1
    }

    @Test
    void naoDeveAdicionarCodigoDuplicado() {
        //TODO
    }

    @Test
    void deveLiberarPatineteDisponivel() {
        //TODO: adicionar patinete 1234 com bateria 80; liberarDisponivel("1234") → true; estado em_uso
    }

    @Test
    void naoDeveLiberarIndisponivelOuInexistente() {
        //TODO
    }

    @Test
    void deveContarDisponiveis() {
        //TODO
    }

    @Test
    void aproveitamentoMaxQuandoSoEmUso() {
        //TODO: um patinete em uso e nenhum disponivel → Double.MAX_VALUE
    }

    @Test
    void deveCompararEstacoesPeloAproveitamento() {
        //TODO: estaNaFrenteDe
    }

    @Test
    void resumoDeveConterCodigoETotais() {
        //TODO: assertTrue(resumo.contains("E1")) etc.
    }
}
