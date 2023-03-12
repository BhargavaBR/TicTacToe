package TicTacToe.Models;

import TicTacToe.Strategy.GameWinningStrategy;
import TicTacToe.Strategy.GameWinningStrategyImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {
    private Board board;
    private List<Player> players;
    private  List<Move> moves;
    private GameStatus gameStatus;
    private int playerTurn;
    private GameWinningStrategy gameWinningStrategy;
    private  Player winner;

    public void display(){
        this.board.printBoard();
    }

    public void makeNextMove(){
        Player toMovePlayer = players.get(playerTurn);
        System.out.println("Move is for Player " + toMovePlayer.getName()+"'s: ");
        Move move = toMovePlayer.decideMove(this.board);

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        System.out.println("Move Happened : row -> " + row + " col -> " + col);
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(toMovePlayer);

        Move playedMove = new Move(toMovePlayer,board.getBoard().get(row).get(col));
        this.moves.add(playedMove);

        if(gameWinningStrategy.updateAndCheckForWinner(board,toMovePlayer,playedMove)){
            gameStatus = GameStatus.WIN;
            winner = toMovePlayer;
        }
        playerTurn = playerTurn + 1;
        playerTurn = playerTurn % players.size();

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }


    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }
    private void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder {
        private int dimension;
        private List<Player> players;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Game build(){
            Game game = new Game();
            game.setGameStatus(GameStatus.INPROGRESS);
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setBoard(new Board(dimension));
            game.setPlayerTurn(0);
            game.setGameWinningStrategy(new GameWinningStrategyImpl(dimension));

            return  game;
        }
    }


}
