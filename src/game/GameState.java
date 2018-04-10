package game;

public enum GameState {

    WIN,
    ONGOING,
    DRAW,
    ILLEGAL_MOVE,

    /**
     * ILLEGAL MOVE - avoid these, mark these down to 0;
     * WIN - promote moves that lead to win +1;
     * LOSS - demote moves that lead to this -1;
     * DRAW - no nothing
     * */


}
