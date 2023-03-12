package TicTacToe.Controller;

import TicTacToe.Models.Game;
import TicTacToe.Models.GameStatus;
import TicTacToe.Models.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        try{
            return Game.getBuilder()
                    .setDimension(dimension)
                    .setPlayers(players)
                    .build();


        }catch (Exception e){
            System.out.println("Caught exception");
            e.printStackTrace();
            return null;
        }
    }

    public  void displayBoard(Game game){
        game.display();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }


}
