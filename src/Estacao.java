
import java.util.ArrayList;
import java.util.List;

/**
 * Estação que agrega patinetes.
 * Complete os métodos marcados com //TODO.
 */
public class Estacao {
    private String codigo;
    private List<Patinete> patinetes;

    public Estacao(String codigo) {
        this.codigo = codigo == null ? "" : codigo;
        this.patinetes = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    /**
     * Adiciona patinete à frota se o código ainda não existir na estação.
     * @return true se adicionou; false se nulo ou código duplicado
     */
    public boolean adicionar(Patinete p) {
        //TODO
        return false;
    }

    /**
     * Localiza pelo código; se estiver disponivel, inicia aluguel.
     */
    public boolean liberarDisponivel(String codigo) {
        //TODO
        return false;
    }

    public int totalPatinetes() {
        return patinetes.size();
    }

    public int totalDisponiveis() {
        //TODO
        return 0;
    }

    public int totalEmUso() {
        //TODO
        return 0;
    }

    /**
     * em_uso / (disponivel + em_uso).
     * Frota sem disponivel nem em_uso → 0.
     * Só em_uso (sem disponivel) → Double.MAX_VALUE.
     */
    public double aproveitamentoFrota() {
        //TODO
        return 0.0;
    }

    /**
     * Critério 1: maior aproveitamentoFrota.
     * Empate: maior totalDisponiveis.
     * Empate total: false.
     */
    public boolean estaNaFrenteDe(Estacao outra) {
        //TODO
        return false;
    }

    /**
     * Formato sugerido:
     * COD | total=T | disp=D | uso=U | aproveitamento=XX.X%
     * ou aproveitamento=MAX
     */
    public String resumo() {
        //TODO
        return "";
    }
}
