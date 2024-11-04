package org.example;

import java.util.List;

public class Board {

    private final List<String> CELLS;

    public Board(List<String> CELLS) {
        this.CELLS = CELLS;
    }

    public void occupyCell(int position) {
        boolean isInBoardLimits = position <= 0 || position > CELLS.size();
        if (isInBoardLimits) {
            return;
        }
        CELLS.set(position - 1, "X");
    }

    public List<String> course() {
        return CELLS;
    }
}
