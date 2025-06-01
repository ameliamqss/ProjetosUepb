public class HistoricoAcao {
    private String usuario;
    private String acao;
    private String produto;
    private int quantidade;

    public HistoricoAcao(String usuario, String acao, String produto, int quantidade) {
        this.usuario = usuario;
        this.acao = acao;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Usuário " + usuario + " " + acao + " " + quantidade + " unidades do produto " + produto;
    }
}