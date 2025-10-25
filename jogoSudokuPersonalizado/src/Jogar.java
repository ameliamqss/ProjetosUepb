import java.util.Scanner;

public class Jogar {

    private String escolha;
    Scanner s = new Scanner(System.in);

    public Jogar(){}

    public void sequencia(){
        LogicaJogo j= new LogicaJogo();
        j.colherDados();
        j.corrigirDigito();
        System.out.println("Resultado: ");
        j.conferirResultadoMatriz();
    }

    public void play(){
        sequencia();
        System.out.println("Deseja jogar novamente o jogo?-> S ou N");
        escolha= s.nextLine();
        if(escolha.equalsIgnoreCase("S")){
            play();
        }else{
            System.out.println("Finalizando.");
        }
    }
}
