package System_Design.LLD.TIC_TAC_TOE;

public class MainGame {
    public static void main(String[] args){
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        System.out.println("game winner is: "+ticTacToeGame.startGame());
    }
}
