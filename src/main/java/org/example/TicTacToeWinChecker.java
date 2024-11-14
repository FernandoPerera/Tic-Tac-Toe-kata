package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TicTacToeWinChecker {
    private final List<WinChecker> WIN_CHECKERS;

    public TicTacToeWinChecker() {
        this.WIN_CHECKERS = Arrays.asList(
                new DiagonalWinChecker(),
                new HorizontalWinChecker(),
                new VerticalWinChecker()
        );
    }

    public Optional<String> findWinner(List<String> boardCells) {
        return WIN_CHECKERS.stream()
                .map(checker -> checker.checkWin(boardCells))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }

    public boolean isGameStuck(List<String> boardCells) {
        return boardCells.stream()
                .allMatch(cell -> Arrays.stream(Piece.values())
                        .map(Piece::name)
                        .anyMatch(cell::equals));
    }

}
