package util;

public class Stats {
    private static Stats ourInstance = new Stats();

    public static Stats getInstance() {
        return ourInstance;
    }

    private Stats() {
    }

    public int games = 0;
    public int wins = 0;
    public int illegalMoves = 0;
    public int draws = 0;

    public void reset() {
        games = 0;
        wins = 0;
        illegalMoves = 0;
        draws = 0;
    }
}
