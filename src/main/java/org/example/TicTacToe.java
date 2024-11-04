package org.example;

import java.util.Arrays;
import java.util.List;

public class TicTacToe implements GameBoard {

    private static final List<String> BOARD = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    @Override
    public void playIn(int position) {
        boolean isInBoardLimits = position <= 0 || position > BOARD.size();
        if (isInBoardLimits) {
            throw new ArrayIndexOutOfBoundsException("Last index is 9 !!");
        }
        BOARD.set(position - 1, "X");
    }

    @Override
    public String getBoard() {
        return Printer.display(BOARD);
    }
}
