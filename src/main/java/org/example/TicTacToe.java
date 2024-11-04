package org.example;

import java.util.Arrays;

public class TicTacToe implements GameBoard {

    private final Board BOARD = new Board(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

    @Override
    public void playIn(int position) {
        BOARD.occupyCell(position);
    }

    @Override
    public String getBoard() {
        return Printer.display(BOARD.course());
    }
}
