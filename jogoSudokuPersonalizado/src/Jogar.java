import java.util.Scanner;

public class Jogar {
    private String escolha;
    LogicaJogo j= new LogicaJogo();
    Scanner s = new Scanner(System.in);

    public Jogar(){}

    public void sequencia(){
        j.colherDados();
        j.corrigirDigito();
        j.conferirResultadoMatriz();
    }

    public void jogar(){
        sequencia();
        System.out.println("Deseja jogar novamente o jogo?-> S ou N");
        escolha= s.nextLine();
        if(escolha.equalsIgnoreCase("S")){
            sequencia();
        }else{
            System.out.println("Finalizando.");
        }
    }
}
