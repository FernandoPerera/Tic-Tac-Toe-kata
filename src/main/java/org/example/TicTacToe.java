package org.example;

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

        if (lastMove.equals(X_PIECE)) {
            piece = O_PIECE;
        } else {
            piece = X_PIECE;
        }

        super.BOARD.occupyCell(position, piece);
        lastMove = piece;
    }
}
