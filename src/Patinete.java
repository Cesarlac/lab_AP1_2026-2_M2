
/**
 * Patinete elétrico da Xulambs Mobility.
 * Classe fornecida (já implementada) — não precisa alterar para a atividade.
 */
public class Patinete {
    public static final int BATERIA_MIN = 0;
    public static final int BATERIA_MAX = 100;
    public static final int LIMIAR_INDISPONIVEL = 20;

    private String codigo;
    private int bateria;
    private boolean emUso;

    public Patinete(String codigo, int bateria) {
        this.codigo = "0000";
        this.bateria = BATERIA_MIN;
        this.emUso = false;
        if (codigo != null && codigo.length() == 4) {
            this.codigo = codigo;
        }
        if (bateria >= BATERIA_MIN && bateria <= BATERIA_MAX) {
            this.bateria = bateria;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public int getBateria() {
        return bateria;
    }

    public boolean atualizarBateria(int valor) {
        if (valor < BATERIA_MIN || valor > BATERIA_MAX) {
            return false;
        }
        this.bateria = valor;
        return true;
    }

    public String estado() {
        if (emUso) {
            return "em_uso";
        }
        if (bateria < LIMIAR_INDISPONIVEL) {
            return "indisponivel";
        }
        return "disponivel";
    }

    public boolean iniciarAluguel() {
        if (!"disponivel".equals(estado())) {
            return false;
        }
        emUso = true;
        return true;
    }

    public boolean encerrarAluguel() {
        if (!emUso) {
            return false;
        }
        emUso = false;
        return true;
    }
}
