
import java.util.ArrayList;
import java.util.List;

/**
 * Estação que agrega patinetes.
 * Complete os métodos marcados com //TODO (Tarefas 1, 2 e 3).
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
        if (p == null) {
            return false;
        }
        for (Patinete existente : patinetes) {
            if (existente.getCodigo().equals(p.getCodigo())) {
                return false;
            }
        }
        patinetes.add(p);
        return true;
    }

    /**
     * Localiza pelo código; se estiver disponivel, inicia aluguel.
     * @return true se iniciou o aluguel; false se não encontrou ou não está disponivel
     */
    public boolean liberarDisponivel(String codigo) {
        for (Patinete patinete : patinetes) {
            if(this.codigo.equals(codigo) && patinete.iniciarAluguel()){
                return true;
            }
        }
        return false;
    }

    public int totalPatinetes() {
        return patinetes.size();
    }

    public int totalDisponiveis() {
        int total = 0;
        for (Patinete p : patinetes) {
            if ("disponivel".equals(p.estado())) {
                total++;
            }
        }
        return total;
    }

    public int totalEmUso() {
        int total = 0;
        for (Patinete p : patinetes) {
            if ("em_uso".equals(p.estado())) {
                total++;
            }
        }
        return total;
    }

    /**
     * em_uso / (disponivel + em_uso).
     * Frota sem disponivel nem em_uso → 0.
     * Só em_uso (sem disponivel) → Double.MAX_VALUE.
     */
    public double aproveitamentoFrota() {
        double disponiveis = totalDisponiveis();
        double emUso = totalEmUso();
        double aproveitamento = emUso / disponiveis + emUso;
        if (aproveitamento > 0){
            return Double.MAX_VALUE;
        }
        return 0.0;
    }

    /**
     * Critério 1: maior aproveitamentoFrota.
     * Empate: maior totalDisponiveis.
     * Empate total: false.
     */
    public boolean estaNaFrenteDe(Estacao outra) {

        if (this.aproveitamentoFrota() > outra.aproveitamentoFrota()){
            return true;
        }
        if(this.aproveitamentoFrota() == outra.aproveitamentoFrota()){
            if (this.totalDisponiveis() > outra.totalDisponiveis()){
                return true;
            }
        }
        return false;
    }

    /**
     * COD | total=T | disp=D | uso=U | aproveitamento=XX.X%
     * ou aproveitamento=MAX
     */
    public String resumo() {
        double apr = aproveitamentoFrota();
        String aprTxt;
        if (apr == Double.MAX_VALUE) {
            aprTxt = "MAX";
        } else {
            aprTxt = String.format("%.1f%%", apr * 100.0);
        }
        return codigo
                + " | total=" + totalPatinetes()
                + " | disp=" + totalDisponiveis()
                + " | uso=" + totalEmUso()
                + " | aproveitamento=" + aprTxt;
    }
}
