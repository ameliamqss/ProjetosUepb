import java.util.Scanner;

public abstract class Usuario {
	//senha foi adicionado
    protected String nome;
    protected String senha;
    protected Scanner sc = new Scanner(System.in);
    
    public Usuario() {
    	
    }
    //novo construtor, para gerenciar usuario e senha
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    //metodo modificado para inseção da senha
    public void cadastrarUsuario() {
    	System.out.println("Digite o nome do usuário: ");
        String nomeDigitado = sc.nextLine();
        this.nome = nomeDigitado;

        System.out.println("Digite a senha do usuário: ");
        this.senha = sc.nextLine();

        System.out.println("Usuário " + this.nome + " pronto para ser adicionado ao sistema.");
    }

    public void exibirUsuario() {
        if (this.nome == null) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("O usuário é: " + this.nome);
        }
    }

    public abstract boolean podeEditar();
    public abstract boolean podeRemover();
    
    public boolean podeVerHistorico() {
        return false; 
    }

    public String getNome() {
        return nome;
    }
    
    //metodo para verificar se a senha que foi informada e a mesma que foi armazenada
    public boolean verificarSenha(String senhaFornecida) {
        return this.senha != null && this.senha.equals(senhaFornecida);
    }
}