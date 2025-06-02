import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in); //
  
    private ArrayList<Usuario> usuariosCadastrados = new ArrayList<>();
    //estoque agora é estanciado em menu
    private Estoque estoque = new Estoque();
    
    //metodo para verificar se o nome do usuário bate com o nome fornecido.
    private Usuario encontrarUsuario(String nome) {
        for (Usuario user : usuariosCadastrados) {
            if (user.getNome().equalsIgnoreCase(nome)) {
                return user;
            }
        }
        return null;
    }
    
    //menu do tipo de usuario
    private void cadastrar_usuario() {
        System.out.println("\n--- Cadastro de Novo Usuário ---");
        System.out.println("Escolha o tipo de usuário:");
        System.out.println("1 - Administrador");
        System.out.println("2 - Colaborador");
        System.out.print("Opção: ");
        try {
        int entradaTipo = sc.nextInt();
        sc.nextLine(); 
        int tipoOpcao = -1;
        
        // Validação simples para a entrada do tipo de usuário
        if (entradaTipo==1) {
            tipoOpcao = 1;
        } else if (entradaTipo==2) {
            tipoOpcao = 2;
        } else {
             throw new ConferirRespostaMenu("Entrada inválida para tipo. Tente novamente.");
        }

        System.out.print("Digite o nome de usuário: ");
        String nome = sc.nextLine();
        if (nome.trim().isEmpty()) {
            System.out.println("Nome não pode ser vazio.");
            return;
        }
        if (encontrarUsuario(nome) != null) {
            System.out.println("Usuário já existe com este nome!");
            return;
        }

        System.out.print("Digite a senha: ");
        String senha = sc.nextLine();
        if (senha.trim().isEmpty()) {
            System.out.println("Senha não pode ser vazia.");
            return;
        }
        
        //decide qual tipo de usuario adicionar com base na variavel tipoOpcao
        Usuario novoUsuario = null;
        switch (tipoOpcao) {
            case 1:
                novoUsuario = new Administrador(nome, senha); //
                break;
            case 2:
                novoUsuario = new Colaborador(nome, senha); //
                break;
            default: 
                System.out.println("Tipo de usuário inválido (erro interno).");
                return;
        }
        
        usuariosCadastrados.add(novoUsuario);
        System.out.println("Usuário '" + nome + "' cadastrado com sucesso!");
        } catch (ConferirRespostaMenu e) {
        System.out.println(e.getMessage());
    } catch (java.util.InputMismatchException e) {
        System.out.println("Entrada inválida! Digite apenas números.");
        sc.nextLine(); 
    }
    }
    
    //metodo de login do usuario
    private Usuario login_usuario() {
        System.out.println("\n--- Login ---");
        if (usuariosCadastrados.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado. Por favor, cadastre um usuário primeiro.");
            return null;
        }
        System.out.print("Nome de usuário: ");
        String nome = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario usuarioEncontrado = encontrarUsuario(nome);
        if (usuarioEncontrado != null && usuarioEncontrado.verificarSenha(senha)) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + usuarioEncontrado.getNome() + ".");
            return usuarioEncontrado;
        } else {
            System.out.println("Nome de usuário ou senha incorretos.");
            return null;
        }
    }
    
    //menu principal modificado para funcionar com as novas alterações.
    public void menuPrincipal() {
        int opcaoMenuPrincipal = -1; 

        do {
        System.out.println("\n--- Sistema de Estoque ---");
        System.out.println("1 - Cadastrar Novo Usuário");
        System.out.println("2 - Fazer Login");
        System.out.println("0 - Sair do Programa");
        System.out.print("Escolha uma opção: ");
        
        try {
            opcaoMenuPrincipal = sc.nextInt(); 
            sc.nextLine();

            switch (opcaoMenuPrincipal) {
                case 1:
                    cadastrar_usuario();
                    break;
                case 2:
                    Usuario usuarioLogado = login_usuario();
                    if (usuarioLogado != null) {
                        estoque.usuario_logado(usuarioLogado);
                        estoque.menu();
                        estoque.usuario_logado(null);
                    }
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    throw new ConferirRespostaMenu("Opção inválida! Tente novamente.");
            }
        } catch (ConferirRespostaMenu e) {
            System.out.println(e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, insira um número.");
            sc.nextLine(); 
        } 
    } while (opcaoMenuPrincipal != 0); 
    }
}


