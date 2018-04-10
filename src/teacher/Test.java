package teacher;

import game.Board;
import game.GameState;
import player.Player;
import util.Stats;

public class Test {

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    private Board board = null;
    private GameState gameState;

    public Test(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        board = new Board(player1, player2);
    }

    public GameState testOneTurn() {
        Stats.getInstance().games++;

        gameState = board.takeTurn(currentPlayer);
        currentPlayer.updateGameMemory(gameState);

        switchPlayers();

        gameState = board.takeTurn(currentPlayer);
/*        if (gameState == GameState.ONGOING) {
            Stats.getInstance().wins++;
            gameState = GameState.WIN;
        }*/
        currentPlayer.updateGameMemory(gameState);

        return gameState;
    }

    public GameState test() {
        Stats.getInstance().games++;
        gameState = GameState.ONGOING;

        while (gameState == GameState.ONGOING) {
            gameState = board.takeTurn(currentPlayer);
            currentPlayer.updateGameMemory(gameState);

            if (gameState == GameState.ONGOING) {
                switchPlayers();
            }
        }

        return gameState;
    }

    private void switchPlayers() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
