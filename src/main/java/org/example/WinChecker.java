package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class WinChecker {

    protected boolean isGamePiece(String value) {
        return Arrays.stream(Piece.values())
                .map(Piece::name)
                .anyMatch(value::equals);
    }

    protected String obtainWinnerBy(String cellValue) {
        return cellValue.equals(Piece.X.name())
                ? GameStates.P1_WINS.name()
                : GameStates.P2_WINS.name();
    }

    abstract Optional<String> checkWin(List<String> boardCells);

}
