package TicTacToe.Strategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Player;
import TicTacToe.Models.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GameWinningStrategyImpl implements  GameWinningStrategy{
    List<HashMap<Character,Integer>> rowSymbolCount = new ArrayList<>();
    List<HashMap<Character,Integer>> columnSymbolCount = new ArrayList<>();
    HashMap<Character,Integer> diagonalCount = new HashMap<>();
    HashMap<Character,Integer> reverseDiagonalCount = new HashMap<>();
    int dimension;

    public GameWinningStrategyImpl(int dimension){
        this .dimension = dimension;
        for(int i=0;i<dimension;i++){
            rowSymbolCount.add(new HashMap<>());
            columnSymbolCount.add(new HashMap<>());
        }
    }

    public boolean isDiagonal(int row, int column){
        return (row==column);
    }

    public  boolean isReverseDiagonal(int row, int column){
        return (row+column == dimension);
    }

    @Override
    public boolean updateAndCheckForWinner(Board board, Player lastMovePlayer, Move lastMove) {
        char symbol = lastMovePlayer.getSymbol();
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        rowSymbolCount.get(row).put(symbol, rowSymbolCount.get(row).getOrDefault(symbol,0)+1);
        columnSymbolCount.get(col).put(symbol, columnSymbolCount.get(col).getOrDefault(symbol,0)+1);

        if(isDiagonal(row, col)){
            diagonalCount.put(symbol,diagonalCount.getOrDefault(symbol,0)+1);
        }
        if(isReverseDiagonal(row,col)){
            reverseDiagonalCount.put(symbol, reverseDiagonalCount.getOrDefault(symbol,0)+1);
        }
        return checkWinner(row,col,symbol);
    }

    public boolean checkWinner(int row, int col, char symbol){
        if(rowSymbolCount.get(row).get(symbol) == dimension) return true;

        if(columnSymbolCount.get(col).get(symbol) == dimension) return true;

        if(isDiagonal(row, col)) {
            if(diagonalCount.get(symbol) == dimension) return true;
        }
        if(isReverseDiagonal(row, col)) {
            if(reverseDiagonalCount.get(symbol) == dimension) return true;
        }
        return false;
    }
}
