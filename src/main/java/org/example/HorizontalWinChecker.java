package org.example;

import java.util.List;
import java.util.Optional;

public class HorizontalWinChecker extends WinChecker {

    @Override
    Optional<String> checkWin(List<String> boardCells) {
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

}
