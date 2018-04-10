package teacher;

import game.Board;
import game.GameState;
import player.ComputerPlayer;
import player.Player;
import player.babybot.BabyBot;
import util.Print;
import util.Stats;

import java.util.Collections;
import java.util.List;

public class TeacherBot {

    public void test2(List<Player> bots) {
        for (int i=0 ; i<bots.size() ; i++) {
            Player player1 = new ComputerPlayer();
            Player player2 = bots.get(i);
            Test test = new Test(player1, player2);
            GameState result = test.test();

            player2.markPlayerStrategies(result);
        }
    }

    public void test(List<Player> bots) {
        for (int i=0 ; i<bots.size() ; i++) {
            Player player1 = bots.get(i);
            for (int j=0 ; j<bots.size() ; j++) {
                if(i == j) {
                    continue;
                }
                Player player2 = bots.get(j);

                Test test = new Test(player1, player2);
                GameState result = test.test();

                player1.markPlayerStrategies(result);
                player2.markPlayerStrategies(result);


              /*  GameState gameState = test.getGameState();
                Player currentPlayer = test.getCurrentPlayer();

                if (gameState == GameState.WIN) {
                    int playerScore = currentPlayer.getPlayerScore();
                    currentPlayer.setPlayerScore(playerScore + 2);
                }
                if (gameState == GameState.ILLEGAL_MOVE) {
                    int playerScore = currentPlayer.getPlayerScore();
                    currentPlayer.setPlayerScore(playerScore - 2);
                }*/
            }
        }

    }



    private void printScores(List<Player> bots) {
        for (Player bot : bots) {
            System.out.print(bot.getPlayerScore() + "\t");
        }
        System.out.println();
    }
}
