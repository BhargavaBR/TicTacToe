package TicTacToe.Strategy;

import TicTacToe.Models.Board;
import TicTacToe.Models.Move;
import TicTacToe.Models.Player;

public interface GameWinningStrategy {
    boolean updateAndCheckForWinner(Board board, Player lastMovePlayer, Move lastMove);
}
