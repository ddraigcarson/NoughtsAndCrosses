package player;

import game.GameState;
import game.NoughtOrCross;
import player.babybot.Strategy;
import util.Maths;

import java.util.List;
import java.util.Map;

public class ComputerPlayer implements Player {

    private NoughtOrCross noughtOrCross;

    @Override
    public NoughtOrCross getNoughtOrCross() {
        return noughtOrCross;
    }

    @Override
    public void setNoughtOrCross(NoughtOrCross value) {
        this.noughtOrCross = value;
    }

    @Override
    public int getPlayerScore() {
        return 0;
    }

    @Override
    public void setPlayerScore(int value) {

    }

    @Override
    public Map<String, Strategy> getMemory() {
        return null;
    }

    @Override
    public void addToMemory(Map<String, Strategy> value) {

    }

    @Override
    public int chooseMove(List<NoughtOrCross> board) {
        return Maths.randomInt(0, 9);
    }

    @Override
    public void updateGameMemory(GameState result) {

    }

    @Override
    public void markPlayerStrategies(GameState result) {

    }
}
