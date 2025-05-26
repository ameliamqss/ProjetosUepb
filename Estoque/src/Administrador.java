public class Administrador extends Usuario{

    @Override
    public boolean podeEditar() {
        return true;
    }

    @Override
    public boolean podeRemover() {
        return true;
    }
    
}
