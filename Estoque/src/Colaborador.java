public class Colaborador extends Usuario {

    @Override
    public boolean podeEditar() {
        return false; 
    }

    @Override
    public boolean podeRemover() {
        return false; 
    }
    
}
