package game;

import player.Player;
import util.Stats;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<NoughtOrCross> board;

    public Board(Player player1, Player player2) {
        newBoard();
        player1.setNoughtOrCross(NoughtOrCross.X);
        player2.setNoughtOrCross(NoughtOrCross.O);
    }

    public GameState takeTurn(Player currentPlayer) {
        int playerChoice = currentPlayer.chooseMove(board);

        if (checkForIllegalMove(playerChoice)) {
            Stats.getInstance().illegalMoves++;
            return GameState.ILLEGAL_MOVE;
        }

        board.set(playerChoice, currentPlayer.getNoughtOrCross());

        if (checkForDraw()) {
            Stats.getInstance().draws++;
            return GameState.DRAW;
        }

        if (checkForWin()) {
            Stats.getInstance().wins++;
            return GameState.WIN;
        }

        return GameState.ONGOING;
    }

    private boolean checkForIllegalMove(int playerChoice) {
        return board.get(playerChoice) != NoughtOrCross.N;
    }

    private boolean checkForDraw() {
        return !board.contains(NoughtOrCross.N);
    }

    private boolean checkForWin() {
        for (WinCondition winCondition : WinCondition.values()) {
            int[] winningPositions = winCondition.getPositions();
            NoughtOrCross p1 = board.get(winningPositions[0]);
            NoughtOrCross p2 = board.get(winningPositions[1]);
            NoughtOrCross p3 = board.get(winningPositions[2]);

            if(p1 != NoughtOrCross.N && p1 == p2 && p2 == p3) {
                return true;
            }
        }
        return false;
    }

    private void newBoard() {
        board = new ArrayList<NoughtOrCross>();
        for (int i=0 ; i<9 ; i++) {
            board.add(NoughtOrCross.N);
        }
    }

}
