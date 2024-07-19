package System_Design.LLD.TIC_TAC_TOE.Model;

import System_Design.LLD.TIC_TAC_TOE.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size){
        this.size = size;
        board=new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col,PlayingPiece playingPiece){
        if(board[row][col]!=null){
            return false;
        }
        board[row][col] = playingPiece;
        return true;
    }

    public List<Pair<Integer,Integer>> getFreeCells(){
        List<Pair<Integer,Integer>> freeCells = new ArrayList<>();

        for (int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if (board[i][j]==null){
                    Pair<Integer,Integer> rowColums = new Pair<>(i,j);

                    freeCells.add(rowColums);
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

    }
