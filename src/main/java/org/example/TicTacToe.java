package org.example;

import java.util.Arrays;
import java.util.List;

public class TicTacToe implements GameBoard {

    private static final String HORIZONTAL_BOARD_DIVISION = "----------";
    private static final String VERTICAL_BOARD_DIVISION = " | ";

    public TicTacToe(){}
    private List<String> board = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    @Override
    public void playIn(int position) {
        if (position <= 0 || position > board.size()) {
            throw new ArrayIndexOutOfBoundsException("Last index is 9 !!");
        }
        board.set(position - 1, "X");
    }

    @Override
    public String getBoard() {

        StringBuilder representation = new StringBuilder();
        for (int i = 0; i < board.size(); i++){
            boolean isLastRow = i == board.size() - 1;
            boolean mustPlaceHorizontalDivision = (i + 1) % 3 == 0;

            if (isLastRow){
                representation.append(board.get(i));
            }else if (mustPlaceHorizontalDivision) {
                    representation.append(board.get(i)).append("\n" + HORIZONTAL_BOARD_DIVISION + "\n");
            } else {
                    representation.append(board.get(i)).append(VERTICAL_BOARD_DIVISION);
            }
        }

        return representation.toString();
    }
}
