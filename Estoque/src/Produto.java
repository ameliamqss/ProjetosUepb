
import java.util.Scanner;

public class Produto {
    private String nome;
    private String marca;
    private String categoria;
    private int quantidade;
    Scanner sc= new Scanner (System.in);

    public Produto() {
        adicionaProduto();
    }

    public void adicionaProduto(){
        System.out.print("Informe o nome do produto: ");
        nome = sc.nextLine();
        System.out.print("Informe a marca do produto: ");
        marca = sc.nextLine();
        System.out.print("Informe a categoria do produto: ");
        categoria = sc.nextLine();
        do{
            System.out.print("Informe a quantidade do produto (maior que 0): ");
            quantidade = sc.nextInt();
        }while(quantidade<1);
        sc.nextLine();
    }

    public void imprimirProduto() {
        System.out.println("Nome: " + nome + " | Marca: " + marca + " | Categoria: " + categoria + " | Quantidade: " + quantidade);
    }

    public void editarProduto(){
        System.out.println("---Iniciando a modificação do produto---");
        adicionaProduto();
    }

    public String getNome() {
        return nome;
    }
    public String getMarca() {
        return marca;
    }

    public String getCategoria() {
        return categoria;
    }
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
}
}
