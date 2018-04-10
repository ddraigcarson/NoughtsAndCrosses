package util;

import player.Player;

import java.util.List;

public class Print {
    private static Print ourInstance = new Print();

    public static Print getInstance() {
        return ourInstance;
    }

    private Print() {
    }

    public void printBotsMemorySizes(List<Player> bots) {
        System.out.println("-------------------------");
        System.out.println("MEMORY");
        System.out.println("-------------------------");
        for (Player bot : bots) {
            System.out.print(bot.getMemory().size() + "\t");
        }
        System.out.println();
        System.out.println("-------------------------");
    }

    public void printRoundSummary(int generation) {

        System.out.println(generation + "\tGames: " + Stats.getInstance().games
                + "\t\tWins: " + Stats.getInstance().wins
                + "\t\tDraws: " + Stats.getInstance().draws
                + "\t\tIllegal Moves: " + Stats.getInstance().illegalMoves
            );
    }

    public void printRoundPercentages(int generation) {
        int illegalMovesPercent = (int)(((double)Stats.getInstance().illegalMoves/(double)Stats.getInstance().games)*100);
        int drawsPercent = (int)(((double)Stats.getInstance().draws/(double)Stats.getInstance().games)*100);
        int winsPercent = (int)(((double)Stats.getInstance().wins/(double)Stats.getInstance().games)*100);

        System.out.println(generation + "\tGames: " + Stats.getInstance().games
                + "\t\tWins: " + winsPercent + "%"
                + "\t\tDraws: " + drawsPercent + "%"
                + "\t\tIllegal Moves: " + illegalMovesPercent + "%"
        );
    }
}
