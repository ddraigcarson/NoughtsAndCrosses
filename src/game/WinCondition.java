package game;

public enum WinCondition {

    SIDE_1(new int[]{0, 1, 2}),
    SIDE_2(new int[]{3, 4, 5}),
    SIDE_3(new int[]{6, 7, 8}),
    DOWN_1(new int[]{0, 3, 6}),
    DOWN_2(new int[]{1, 4, 7}),
    DOWN_3(new int[]{2, 5, 8}),
    DIAG_1(new int[]{0, 4, 8}),
    DIAG_2(new int[]{2, 4, 6});

    private final int[] positions;

    private WinCondition(int[] positions) {
        this.positions = positions;
    }

    public int[] getPositions() {
        return positions;
    }


}
