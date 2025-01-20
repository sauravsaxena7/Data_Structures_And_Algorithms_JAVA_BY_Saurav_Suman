package System_Design.LLD.Snack_and_ladder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    Board(int boardSize, int numOfSnakes, int numOfLadders){
        initializeCells(boardSize);
        addSnakesLadder(cells,numOfLadders,numOfSnakes);
    }

    private void addSnakesLadder(Cell[][] cells, int numOfLadders, int numOfSnakes) {

        while (numOfLadders>0){
            int ladderStart = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);

            if(ladderStart>=ladderEnd){
                continue;
            }

            SnackLadderJump ladderJump = new SnackLadderJump();
            ladderJump.start=ladderStart;
            ladderJump.end=ladderEnd;

            Cell cell = getCell(ladderStart);
            cell.jump = ladderJump;

            numOfLadders--;
        }

        while (numOfSnakes>0){
            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length*cells.length-1);
            
            if(snakeTail>=snakeHead){
                continue;
            }
            
            SnackLadderJump snakeJump = new SnackLadderJump();
            snakeJump.start=snakeHead;
            snakeJump.end=snakeTail;
            
            Cell cell = getCell(snakeHead);
            cell.jump = snakeJump;

            numOfSnakes--;
        }


    }

     Cell getCell(int playerPosition) {
        int boardRow = playerPosition/cells.length;
        int boardColumn = (playerPosition%cells.length);
        return cells[boardRow][boardColumn];
    }

    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }


}
