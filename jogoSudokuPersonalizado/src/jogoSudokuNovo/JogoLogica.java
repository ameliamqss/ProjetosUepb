package jogoSudokuNovo;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class JogoLogica {
	
	private int[][]matriz= new int[3][3];
	String resposta;
    protected int numeroSorteado= ThreadLocalRandom.current().nextInt(0, 101);
    Scanner sc= new Scanner (System.in);
    
    int somaColuna1;
    int somaColuna2;
    int somaColuna3;
    int somaLinha1;
    int somaLinha2;
    int somaLinha3;
    
    public JogoLogica() {}
    
    public void mostrarMatriz(int[][]matriz){
        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public void colherDados(){
        System.out.println("o numero sorteado é "+numeroSorteado);
        System.out.println("Matriz atual está vazia");
        mostrarMatriz(matriz);
        System.out.println("Vamos começar a preenchela");
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
            	  System.out.println("Digite um número para a posição ["+ (i+1)+"]["+(j+1)+"]:");
                  matriz[i][j]= sc.nextInt();
                  mostrarMatriz(matriz);
            }}
        	System.out.println("Matriz digitada: ");
        	mostrarMatriz(matriz);
    }
    
    public void colherNovoDigito(){
        System.out.println("Vamos corrigir algum número, você precisará digitar a linha e depois a coluna, posteriormente o valor a ser alterado.");
        System.out.println("Matriz atual");
        mostrarMatriz(matriz);
        System.out.println("Digite a linha a ser alterada: ");
        int linha= sc.nextInt()-1;
        System.out.println("Digite a coluna: ");
        int coluna= sc.nextInt()-1;
        System.out.println("Digite o novo valor: ");
        matriz[linha][coluna]= sc.nextInt();
    }
    
    public void corrigirDigito() {
    	   do {
    	    System.out.println("Deseja corrigir algum numero da Matriz? -> Sim(S), Nao(N)");
    	    resposta = sc.nextLine().trim();
    	    if (resposta.equalsIgnoreCase("S")) {
                colherNovoDigito();
            } else {
                System.out.println("Indo para o próximo passo");
            }}while(resposta.equalsIgnoreCase("S"));
}
    
    
    public void conferirSomaLinha(){

        somaLinha1 = somaLinha2 = somaLinha3 = 0;
        for(int i=0; i<3; i++){
            somaLinha1+=matriz[0][i];
        }
        for(int i=0; i<3; i++){
            somaLinha2+=matriz[1][i];
        }
        for(int i=0; i<3; i++){
            somaLinha3+=matriz[2][i];
        }
    }

    public void conferirSomaColuna(){

        somaColuna1 = somaColuna2 = somaColuna3 = 0;
        for(int i=0; i<3; i++){
            somaColuna1+=matriz[i][0];
    }
        for(int i=0; i<3; i++){
            somaColuna2+=matriz[i][1];  
    }
        for(int i=0; i<3; i++){
            somaColuna3+=matriz[i][2];
    }
}
    public void conferirResultadoMatriz(){
        conferirSomaLinha();
        conferirSomaColuna();
        boolean acertouColuna;
        boolean acertouLinha;
        if(somaColuna1==numeroSorteado && somaColuna2==numeroSorteado && somaColuna3==numeroSorteado){
            acertouColuna=true;
        }else{
            acertouColuna= false;
        }

        if(somaLinha1==numeroSorteado && somaLinha2==numeroSorteado && somaLinha3==numeroSorteado){
            acertouLinha=true;
        }else{
            acertouLinha=false;
        }

        if(acertouColuna && acertouLinha){
            System.out.println("Parabens, a soma da sua coluna e a soma da sua linha estão corretos.");
        }else{
            System.out.println("Errou.");
        }
    }

}
