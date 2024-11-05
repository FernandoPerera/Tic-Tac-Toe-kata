package org.example;

import java.util.Arrays;
import java.util.List;

public class Board {

    private final List<String> CELLS;

    public Board(List<String> CELLS) {
        this.CELLS = CELLS;
    }

    public void occupyCell(int position, Piece pieceToPlay) {
        boolean isInBoardLimits = position <= 0 || position > CELLS.size();
        if (isInBoardLimits) {
            return;
        }

        if (cellIsOccupied(position)) {
            return;
        }

        CELLS.set(position - 1, pieceToPlay.name());
    }

    private boolean cellIsOccupied(int position) {
        return Arrays.stream(Piece.values()).anyMatch(
                piece -> piece.name().equals(CELLS.get(position - 1))
        );
    }

    public List<String> getCells() {
        return CELLS;
    }
}
