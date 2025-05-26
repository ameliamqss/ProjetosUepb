import java.util.Scanner;

public abstract class Usuario {
    protected String nome;
    protected Scanner sc = new Scanner(System.in);

    public Usuario() {}

    public void cadastrarUsuario() {
        System.out.println("Digite o nome do usuário: ");
        String nomeDigitado = sc.nextLine();
        if (this.nome != null && this.nome.equalsIgnoreCase(nomeDigitado)) {
            System.out.println("Já existe esse usuário!");
        } else {
            this.nome = nomeDigitado;
            System.out.println("Usuário cadastrado com sucesso");
        }
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

    public String getNome() {
        return nome;
    }
}