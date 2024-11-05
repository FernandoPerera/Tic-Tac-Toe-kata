package org.example;

import java.util.List;

public class Board {

    private final List<String> CELLS;

    public Board(List<String> CELLS) {
        this.CELLS = CELLS;
    }

    public void occupyCell(int position, String piece) {
        boolean isInBoardLimits = position <= 0 || position > CELLS.size();
        if (isInBoardLimits) {
            return;
        }
        CELLS.set(position - 1, piece);
    }

    public List<String> getCells() {
        return CELLS;
    }
}
