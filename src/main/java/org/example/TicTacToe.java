package org.example;

import java.util.Arrays;
import java.util.List;

public class TicTacToe extends Game {

    private final List<Player> PLAYERS;
    private Player nextPlayerToMove;

    public TicTacToe(Board board, List<Player> PLAYERS) {
        super(board);
        this.PLAYERS = PLAYERS;
        this.nextPlayerToMove = PLAYERS.get(0);
    }

    @Override
    protected void playIn(int position) {
        Board board = super.BOARD;

        board.occupyCell(position, nextPlayerToMove.getPiece());

        nextPlayerToMove = PLAYERS.get(
                PLAYERS.indexOf(nextPlayerToMove) == 0
                        ? 1
                        : 0
        );
    }

    @Override
    protected String getStatus() {
        List<String> boardCells = super.BOARD.getCells();

        for (int i = 0; i < boardCells.size(); i++) {

            String cellValue = boardCells.get(i);
            if (isGamePiece(cellValue)) {

                boolean isFirstRow = i < 3;
                if (isFirstRow) {
                    String centerColValue = boardCells.get(i + 3);
                    String downColValue = boardCells.get(i + 6);

                    if (cellValue.equals(centerColValue) && cellValue.equals(downColValue)){
                        return obtainWinnerBy(cellValue);
                    }
                }

                boolean isInLeftSide = i % 3 == 0;
                if (isInLeftSide) {
                    String midRowValue = boardCells.get(i + 1);
                    String rightRowValue = boardCells.get(i + 2);

                    if (cellValue.equals(midRowValue) && cellValue.equals(rightRowValue)) {
                        return obtainWinnerBy(cellValue);
                    };
                }

            }
        }

        return GameStates.PLAYING.name();
    }

    private static String obtainWinnerBy(String cellValue) {
        return cellValue.equals(Piece.X.name())
                ? GameStates.P1_WINS.name()
                : GameStates.P2_WINS.name();
    }

    private boolean isGamePiece(String value) {
        return Arrays.stream(Piece.values()).anyMatch(
                piece -> piece.name().equals(value)
        );
    }

}
