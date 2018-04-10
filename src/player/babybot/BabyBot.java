package player.babybot;

import game.GameState;
import game.NoughtOrCross;
import player.Player;
import util.Maths;

import java.util.*;

public class BabyBot implements Player {

    private int id;
    private int playerScore = 0;

    private NoughtOrCross noughtOrCross;

    private Map<String, Strategy> gameMemory = new HashMap<String, Strategy>();
    private Map<String, Strategy> fullMemory = new HashMap<String, Strategy>();

    private Strategy lastStrategy;

    public BabyBot(int id) {
        this.id = id;
    }

    @Override
    public int chooseMove(List<NoughtOrCross> board) {
        String boardAsString = Arrays.toString(board.toArray());
        Strategy chosenStrategy = fullMemory.get(boardAsString);

        if (chosenStrategy == null) {
            chosenStrategy = Strategy.newStrategy(boardAsString);
        }
        int move = chosenStrategy.pickMove();

        lastStrategy = chosenStrategy;
        gameMemory.put(boardAsString, chosenStrategy);
        return move;
    }

    @Override
    public void updateGameMemory(GameState result) {
        lastStrategy.setResult(result);
    }

    @Override
    public void markPlayerStrategies(GameState result) {
        for (Strategy strategy : gameMemory.values()) {
            if(result == GameState.WIN) {
                strategy.setResult(result);
            }
            strategy.updateStrategyWithResults();
        }
        fullMemory.putAll(gameMemory);
        gameMemory.clear();
    }

    @Override
    public void setNoughtOrCross(NoughtOrCross value) {
        this.noughtOrCross = value;
    }

    @Override
    public NoughtOrCross getNoughtOrCross() {
        return noughtOrCross;
    }

    @Override
    public void setPlayerScore(int value) {
        this.playerScore = value;
    }

    @Override
    public int getPlayerScore() {
        return playerScore;
    }

    @Override
    public Map<String, Strategy> getMemory() {
        return fullMemory;
    }

    @Override
    public void addToMemory(Map<String, Strategy> value) {
        for (String boardState : value.keySet()) {
            fullMemory.put(boardState, value.get(boardState));
        }
    }

    public static Comparator<Player> scoreComparator() {
        Comparator<Player> comp = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return Integer.compare(o2.getPlayerScore(), o1.getPlayerScore());
            }
        };
        return comp;
    }

    public static Comparator<Player> randomComparator() {
        Comparator<Player> comp = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                int r1 = Maths.randomInt(0, 9);
                int r2 = Maths.randomInt(0, 1);
                int r3 = Maths.randomInt(1, 5);
                int i1 = r1;
                int i2 = r1;
                if (r2 == 0) {
                    i2 += r3;
                } else {
                    i2 -= r3;
                }
                return Integer.compare(i1, i2);
            }
        };
        return comp;
    }


}
