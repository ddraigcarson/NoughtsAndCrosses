package player;

import game.GameState;
import game.NoughtOrCross;
import player.babybot.Strategy;

import java.util.List;
import java.util.Map;

public interface Player {

    NoughtOrCross getNoughtOrCross();
    void setNoughtOrCross(NoughtOrCross value);

    int getPlayerScore();
    void setPlayerScore(int value);

    Map<String, Strategy> getMemory();
    void addToMemory(Map<String, Strategy> value);

    int chooseMove(List<NoughtOrCross> board);
    void updateGameMemory(GameState result);

    void markPlayerStrategies(GameState result);
}
