package System_Design.LLD.TIC_TAC_TOE;

import System_Design.LLD.TIC_TAC_TOE.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        initializeGame();
    }

    private void initializeGame() {
        gameBoard = new Board(3);
        players = new LinkedList<>();
        PlayingPieceX pieceX = new PlayingPieceX();
        Player player1 = new Player("Player1",pieceX);

        PlayingPieceO pieceO = new PlayingPieceO();
        Player player2  = new Player("Player2",pieceO);

        players.add(player1);
        players.add(player2);

    }

    public String startGame() {
        boolean noWinner=true;
        while (noWinner){

            //take out the player whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();


            //get the free space from the board
            gameBoard.printBoard();

            List<Pair<Integer,Integer>> freeSpaces = gameBoard.getFreeCells();

            if (freeSpaces.isEmpty()){
                noWinner=false;
                continue;
            }

            //read the user Input
            System.out.println("Player; "+playerTurn.name+" Enter row,column: ");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            String[] values = s.split(",");
            int row = Integer.valueOf(values[0]);
            int col = Integer.valueOf(values[1]);

            //place the piece
            boolean pieceAddedSuccessFully = gameBoard.addPiece(row,col, playerTurn.playingPiece);
            if (!pieceAddedSuccessFully){
                //player can not inser the piece into the cell, player has to choose another cell
                System.out.println("Incorect position coosen, try againg");
                players.addFirst(playerTurn);
                continue;
            }

            players.addLast(playerTurn);
            boolean winner = isThereWinner(row,col,playerTurn.playingPiece.pieceType);
            if (winner){
                return playerTurn.name;
            }

        }
        return "tie";
    }

    private boolean isThereWinner(int row, int col, PieceType pieceType) {
        //we can also apply n -queen problem
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i=0;i<gameBoard.size;i++){
            if (gameBoard.board[row][i]==null||gameBoard.board[row][i].pieceType!=pieceType){
                rowMatch=false;
            }
        }

        for (int i=0;i<gameBoard.size;i++){
            if (gameBoard.board[i][col]==null||gameBoard.board[i][col].pieceType!=pieceType){
                colMatch=false;
            }
        }

        for (int i=0,j=0;i<gameBoard.size;i++,j++){
            if (gameBoard.board[i][j]==null||gameBoard.board[i][j].pieceType!=pieceType){
                diagonalMatch=false;
            }
        }

        for (int i=0,j=gameBoard.size-1;i<gameBoard.size;i++,j--){
            if (gameBoard.board[i][j]==null||gameBoard.board[i][j].pieceType!=pieceType){
                antiDiagonalMatch=false;
            }
        }

        return rowMatch||colMatch||diagonalMatch||antiDiagonalMatch;


    }
}
