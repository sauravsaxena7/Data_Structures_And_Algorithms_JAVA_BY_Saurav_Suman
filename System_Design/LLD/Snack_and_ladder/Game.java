package System_Design.LLD.Snack_and_ladder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board ;
    Dice dice;
    Deque<Player> players = new LinkedList<>();

    Player winner;

    public Game(){
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10,5,4);
        dice = new Dice(1);
        winner=null;
        addPlayers();

    }

    private void addPlayers() {
        Player p1 = new Player("p1",0);
        Player p2 = new Player("p2",0);

        players.add(p1);
        players.add(p2);
    }


    public void startGame(){
        while(winner==null){
            //check whose turn now;
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn is: "+playerTurn.id + " current Position is "+playerTurn.currentPosition);

            //roll the dice;
            int diceNumbers = dice.rollDice();

            //get the new position
            int playerNewPosition = playerTurn.currentPosition +diceNumbers;

            playerNewPosition=jumpCheck(playerNewPosition);

            playerTurn.currentPosition=playerNewPosition;

            System.out.println("Player turn is: "+playerTurn.id + " new Position is "+playerNewPosition);


            //check for wining conditions
            if(playerNewPosition >=board.cells.length*board.cells.length-1){
                winner=playerTurn;
            }
        }
        System.out.println("Winner is: "+ winner.id);
    }

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition>board.cells.length*board.cells.length-1){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump!=null && cell.jump.start == playerNewPosition){
            String jumpBy = (cell.jump.start<cell.jump.end ? "ladder":"snake");
            System.out.println("Jump done by: "+jumpBy);
            return cell.jump.end;
        }

        return playerNewPosition;
    }

    private Player findPlayerTurn() {
        Player p = players.removeFirst();
        players.addLast(p);
        return p;
    }

}
