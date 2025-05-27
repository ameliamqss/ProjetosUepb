import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Usuario usuario = null;

    int opcaoUsuario;
    public Menu() {} 
    
    public void menuPrincipal() {
        do {
            System.out.println("Menu Usuário:");
            System.out.println("1 - Cadastrar Administrador");
            System.out.println("2 - Cadastrar Operador");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcaoUsuario = sc.nextInt();
            sc.nextLine();

            switch (opcaoUsuario) {
                case 1:
                    usuario = new Administrador();
                    usuario.cadastrarUsuario();
                    usuario.exibirUsuario();
                    break;
                case 2:
                    usuario = new Colaborador();
                    usuario.cadastrarUsuario();
                    usuario.exibirUsuario();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (usuario == null && opcaoUsuario != 0);

        if (usuario != null) {
            Estoque estoque = new Estoque();
            estoque.setUsuarioLogado(usuario);
            estoque.menu();
        }}
    }

