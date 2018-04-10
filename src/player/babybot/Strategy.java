package player.babybot;

import game.GameState;
import util.Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strategy {

    private String boardState;

    private int[] possibilities = new int[9];

    private int move;

    private GameState result;

    private String history = "";

    public int pickMove() {
        List<Integer> probabilities = new ArrayList<Integer>();
        for (int i=0 ; i<9 ; i++) {
            for (int j=0 ; j<possibilities[i] ; j++) {
                probabilities.add(i);
            }
        }
        move = probabilities.get(Maths.randomInt(0, probabilities.size()));
        history+=move;
        return move;
    }

    public void updateStrategyWithResults() {
        switch (result) {
            case WIN:
                possibilities[move]++;
                break;
            case ILLEGAL_MOVE:
                possibilities[move] = 0;
                break;
        }
    }

    public static Strategy newStrategy(String boardState) {
        Strategy newStrategy = new Strategy();
        Arrays.fill(newStrategy.possibilities, 10);
        newStrategy.boardState = boardState;
        return newStrategy;
    }

    public GameState getResult() {
        return result;
    }

    public void setResult(GameState result) {
        this.result = result;
    }
}
