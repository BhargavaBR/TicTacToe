package TicTacToe;

import TicTacToe.Controller.GameController;
import TicTacToe.Models.Game;
import TicTacToe.Models.GameStatus;
import TicTacToe.Models.Player;
import TicTacToe.Models.PlayerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Dimension of TicTacToe Board ");
        int dimension = scan.nextInt();

        GameController gameController = new GameController();

        List<Player> players = new ArrayList<>();
        int n = 2;
        for(int i=0;i<n;i++){
            System.out.println("Name of Player: ");
            String playerName = scan.next();

            System.out.println("Symbol of Player: ");
            String playerSymbol = scan.next();

            players.add(new Player(playerSymbol.charAt(0), playerName, PlayerType.HUMAN));;

        }

        Game game = gameController.createGame(dimension, players);

        while (gameController.getGameStatus(game).equals(GameStatus.INPROGRESS)){
            System.out.println("The current Board is :");
            gameController.displayBoard(game);

            game.makeNextMove();
        }

        System.out.println("Game ended successfully! result is "+game.getGameStatus());
        System.out.println("Final Board is : ");
        gameController.displayBoard(game);
        if(game.getGameStatus().equals(GameStatus.WIN)){
            System.out.println("Winner is : " + game.getWinner().getName());
        }

    }
}
