package org.example;

import java.util.List;
import java.util.Optional;

public class VerticalWinChecker extends WinChecker {

    @Override
    Optional<String> checkWin(List<String> boardCells) {
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

}
