package org.example;

import java.util.List;
import java.util.Optional;

public class DiagonalWinChecker extends WinChecker {

    @Override
    Optional<String> checkWin(List<String> boardCells) {
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

}
