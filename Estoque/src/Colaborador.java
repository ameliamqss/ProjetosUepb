public class Colaborador extends Usuario {

	//2 construtores adicionados
    public Colaborador() {
        super();
    }
    
    public Colaborador(String nome, String senha) {
        super(nome, senha);
    }

    @Override
    public boolean podeEditar() {
        return false; 
    }

    @Override
    public boolean podeRemover() {
        return false; 
    }
    
}
