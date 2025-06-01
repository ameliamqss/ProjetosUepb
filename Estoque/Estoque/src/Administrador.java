public class Administrador extends Usuario{
	
	//2 construtores adicionados
	public Administrador() {
		super();
    }
	
	public Administrador(String nome, String senha) {
        super(nome, senha);
    }

    @Override
    public boolean podeEditar() {
        return true;
    }

    @Override
    public boolean podeRemover() {
        return true;
    }
    @Override
    public boolean podeVerHistorico() {
        return true;
    }
    
}
