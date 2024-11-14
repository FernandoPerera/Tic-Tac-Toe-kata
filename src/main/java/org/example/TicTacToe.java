package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TicTacToe extends Game {

    private final TurnManager TURN_MANAGER;
    private boolean isGameOver = false;

    public TicTacToe(Board board, List<Player> players) {
        super(board);
        this.TURN_MANAGER = new TurnManager(players);
    }

    @Override
    protected void playIn(int position) {
        if (isGameOver) return;

        makeMove(position);
        checkGameStatus();

        TURN_MANAGER.nextTurn();
    }

    private void makeMove(int position) {
        Player currentPlayer = TURN_MANAGER.getCurrentPlayer();
        super.BOARD.occupyCell(position, currentPlayer.getPiece());
    }

    private void checkGameStatus() {
        findWinner(super.BOARD.getCells())
                .ifPresent(winner -> isGameOver = true);
    }

    @Override
    protected String getStatus() {
        List<String> boardCells = super.BOARD.getCells();

        return findWinner(boardCells).orElseGet(
                () -> {
                    boolean allCellsAreOccupied = boardCells.stream().allMatch(this::isGamePiece);
                    return allCellsAreOccupied
                            ? GameStates.STUCK.name()
                            : GameStates.PLAYING.name();
                }
        );
    }

    private Optional<String> findWinner(List<String> boardCells) {
        return Stream.of(
                        obtainWinnerByDiagonalPlay(boardCells),
                        obtainWinnerByRowPlay(boardCells),
                        obtainWinnerByVerticalPlay(boardCells)
                )
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }

    private Optional<String> obtainWinnerByVerticalPlay(List<String> boardCells) {
        for (int boardIndex = 0; boardIndex < 3; boardIndex++) {
            String cellValue = boardCells.get(boardIndex);

            if (isGamePiece(cellValue)) {
                String centerColValue = boardCells.get(boardIndex + 3);
                String downColValue = boardCells.get(boardIndex + 6);

                boolean isWinByVerticalPlay = cellValue.equals(centerColValue) && cellValue.equals(downColValue);
                if (isWinByVerticalPlay) return Optional.of(obtainWinnerBy(cellValue));
            }
        }
        return Optional.empty();
    }

    private Optional<String> obtainWinnerByRowPlay(List<String> boardCells) {
        for (int boardIndex = 0; boardIndex <= (boardCells.size() - 2); boardIndex = boardIndex + 3) {
            String cellValue = boardCells.get(boardIndex);

            if (isGamePiece(cellValue)) {
                String midRowValue = boardCells.get(boardIndex + 1);
                String rightRowValue = boardCells.get(boardIndex + 2);

                boolean isWinByRowPlay = cellValue.equals(midRowValue) && cellValue.equals(rightRowValue);
                if (isWinByRowPlay) return Optional.of(obtainWinnerBy(cellValue));
            }
        }
        return Optional.empty();
    }

    private Optional<String> obtainWinnerByDiagonalPlay(List<String> boardCells) {
        String centerValue = boardCells.get(boardCells.size() / 2);
        if (isGamePiece(centerValue)) {

            boolean isWinByTopLeftDownRightDiagonal = centerValue.equals(boardCells.get(0)) && centerValue.equals(boardCells.get(boardCells.size() - 1));
            boolean isWinByTopRightDownLeftDiagonal = centerValue.equals(boardCells.get(2)) && centerValue.equals(boardCells.get(6));

            if (isWinByTopRightDownLeftDiagonal || isWinByTopLeftDownRightDiagonal) {
                return Optional.of(obtainWinnerBy(centerValue));
            }
        }
        return Optional.empty();
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
