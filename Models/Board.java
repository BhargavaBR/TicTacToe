package TicTacToe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> board ;
    int dimensions;

    public Board(int dimensions) {
        this.dimensions = dimensions;
        this.board = new ArrayList<>();
        for(int i = 0; i < dimensions; i++) {
            this.board.add(new ArrayList<>());
            for (int j = 0; j < dimensions; j++) {
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }

    public  void  printBoard() {
        for(int i = 0; i < dimensions;i++){
            for(int j =0;j<dimensions;j++){
                if(board.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    System.out.print(" |"+ " "+ "| ");
                }
                else{
                    System.out.print(" |"+ board.get(i).get(j).getPlayer().getSymbol() + "| ");
                }
            }
            System.out.println("\n");
        }
    }
}
