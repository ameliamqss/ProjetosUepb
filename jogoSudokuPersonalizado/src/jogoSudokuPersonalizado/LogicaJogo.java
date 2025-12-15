package jogoSudokuPersonalizado;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class LogicaJogo {
    
    private int[][]matriz= new int[3][3];
    protected int numeroSorteado= ThreadLocalRandom.current().nextInt(0, 101);

        int somaColuna1;
        int somaColuna2;
        int somaColuna3;
        int somaLinha1;
        int somaLinha2;
        int somaLinha3;
        String resposta;
        boolean SeEhvalido;
    Scanner sc= new Scanner (System.in);

    public LogicaJogo(){}

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
                if(matriz[i][j]==0){
                boolean valido=false;
                 while(!valido){
                    try{
                    System.out.println("Digite um número para a posição ["+ (i+1)+"]["+(j+1)+"]:");
                    matriz[i][j]= sc.nextInt();
                    sc.nextLine();
                    valido=true;
                    mostrarMatriz(matriz);
            }catch(InputMismatchException e){
                System.out.println("Erro: O valor digitado não é um número, tente novamente.");
                sc.nextLine();
            }}}}}
        
        System.err.println("Matriz digitada:");
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
        //corrigir bug, nao verifica quando somente a coluna ta errado
        if(linha>2 && coluna>2){
            System.out.println("Não foi possivel realizar a correção, pois os valores não correspondem às linhas e colunas disponiveis!");
            return;
            }
        boolean valido= false;
        while(valido==false){
            try{
                System.out.println("Digite o novo valor: ");
                matriz[linha][coluna]= sc.nextInt();
                valido=true;
                sc.nextLine();
                mostrarMatriz(matriz);
            } catch(InputMismatchException e ){
                //verificar, fica infinito
                System.out.println("Erro: o valor digitado não é um número, tente novamente.");
                sc.nextLine();
            }}
    
    }

   public void corrigirDigito() {
   do {
    System.out.println("Deseja corrigir algum numero da Matriz? -> Sim(S), Nao(N)");
    resposta = sc.nextLine().trim();

    try {
        validarResposta(resposta);

        if (resposta.equalsIgnoreCase("S")) {
            colherNovoDigito();
        } else {
            System.out.println("Indo para o próximo passo");
        }

    } catch(EntradaInvalidaException e) {
        System.out.println(e.getMessage());
        sc.nextLine();
        SeEhvalido=false;
    }

} while(resposta.equalsIgnoreCase("S") || SeEhvalido==false);


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

    private void validarResposta(String resposta) throws EntradaInvalidaException {
    if (resposta.length() != 1 ||
       (!resposta.equalsIgnoreCase("S") && !resposta.equalsIgnoreCase("N"))) {
        throw new EntradaInvalidaException("Entrada invalida. Digite apenas 'S' ou 'N'.");
    }
}

}
