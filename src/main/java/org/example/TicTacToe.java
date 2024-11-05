package org.example;

public class TicTacToe extends Game {

    public TicTacToe(Board board) {
        super(board);
    }

    @Override
    protected void playIn(int position) {
        super.BOARD.occupyCell(position);
    }
}
