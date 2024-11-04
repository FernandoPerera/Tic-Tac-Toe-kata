package org.example;

import java.util.Arrays;

public class TicTacToe extends Game {

    public TicTacToe() {
        super(new Board(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9")));
    }

    @Override
    protected void playIn(int position) {
        super.BOARD.occupyCell(position);
    }
}
