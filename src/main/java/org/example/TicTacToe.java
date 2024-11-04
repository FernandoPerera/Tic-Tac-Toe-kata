package org.example;

import java.util.Arrays;
import java.util.List;

public class TicTacToe implements GameBoard {

    private List<String> board = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    @Override
    public void playIn(int position) {
        boolean isInBoardLimits = position <= 0 || position > board.size();
        if (isInBoardLimits) {
            return;
        }
        board.set(position - 1, "X");
    }

    @Override
    public String getBoard() {
        return Printer.display(board);
    }
}
