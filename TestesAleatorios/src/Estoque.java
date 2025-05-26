import java.util.Scanner;
import java.util.ArrayList;

public class Estoque implements AcoesEstoque {
    ArrayList<Produto> produtos = new ArrayList<>();
    private Usuario usuarioLogado;
    
    Scanner sc = new Scanner(System.in);


     public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
    }

    public void adicionarProduto() {
    	System.out.println("Total atual de produtos: " + produtos.size());
        Produto novoProduto = new Produto();
        produtos.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");

    }

    public void listarProdutos() {
       if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Lista de produtos:");
            for (int i = 0; i < produtos.size(); i++) {
                System.out.print((i + 1) + " - ");
                produtos.get(i).imprimirProduto();
            }
        }
    }
    public void removerProduto() {
         if (usuarioLogado == null || !usuarioLogado.podeRemover()) {
            System.out.println("Você não tem permissão para remover produtos.");
            return;
        }
      if (produtos.isEmpty()) {
            System.out.println("Nenhum produto para remover.");
        } else {
            listarProdutos();
            System.out.print("Digite o número do produto a ser removido: ");
            int escolha = sc.nextInt();
            sc.nextLine();

            if (escolha < 1 || escolha > produtos.size()) {
                System.out.println("Escolha inválida.");
            } else {
                Produto p = produtos.get(escolha - 1);
                System.out.print("Digite a quantidade a ser removida: ");
                int qtd = sc.nextInt();

                if (qtd < 1 || qtd > p.getQuantidade()) {
                    System.out.println("Quantidade inválida.");
                } else if (qtd == p.getQuantidade()) {
                    produtos.remove(escolha - 1);
                    System.out.println("Produto removido completamente!");
                } else {
                    p.setQuantidade(- qtd);
                    System.out.println("Quantidade removida com sucesso!");
                }
            }
        }
    }

    public void editarProduto(){
         if (usuarioLogado == null || !usuarioLogado.podeEditar()) {
            System.out.println("Você não tem permissão para editar produtos.");
            return;
        }
      if (produtos.isEmpty()) {
            System.out.println("Não há produtos a serem modificados.");
        } else {
            listarProdutos();
            System.out.println("Digite o número do produto a ser modificado: ");
            int escolha = sc.nextInt();
            if (escolha > 0 && escolha <= produtos.size()) {
                produtos.get(escolha - 1).editarProduto();
            } else {
                System.out.println("Escolha invalida!");
            }
        }

    }

    public void menu() {
        int opcao= -1;
        do {
            System.out.println("\nMenu de Estoque");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Remover produto");
            System.out.println("4 - Editar produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            try{
            opcao = sc.nextInt();
            sc.nextLine();
            if(opcao < 0 || opcao > 4) {
                throw new ConferirRespostaMenu("Opção inválida! Escolha entre 0 e 4.");
            }
           
            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    editarProduto();
                    break;
                case 0:
                    System.out.println("Finalizando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }catch (ConferirRespostaMenu e){
            System.out.println(e.getMessage());
        } catch(java.util.InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, insira um número.");
            sc.nextLine(); 
        } } while (opcao != 0);
        }
    }   
