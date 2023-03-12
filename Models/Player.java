package TicTacToe.Models;

import java.util.Scanner;

public class Player {
    char symbol;
    String name;
    PlayerType playerType;

    public Player(char symbol, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
    }
    public Move decideMove(Board board) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the row! ");
        int row = scan.nextInt();
        System.out.println("Please enter the column! ");
        int col = scan.nextInt();

        return new Move(this, new Cell( row, col));
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
