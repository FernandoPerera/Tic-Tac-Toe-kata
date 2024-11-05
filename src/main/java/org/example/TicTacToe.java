package org.example;

import java.util.List;
import java.util.Optional;

public class TicTacToe extends Game {

    private String lastMove = "";
    private final String X_PIECE = "X";
    private final String O_PIECE = "O";

    public TicTacToe(Board board) {
        super(board);
    }

    @Override
    protected void playIn(int position) {
        String piece;
        Board board = super.BOARD;

        if (lastMove.equals(X_PIECE)) {

            if (List.of(X_PIECE, O_PIECE).contains(board.getCells().get(position - 1))) {
                return;
            }

            piece = O_PIECE;
        } else {
            piece = X_PIECE;
        }

        board.occupyCell(position, piece);
        lastMove = piece;
    }
}
