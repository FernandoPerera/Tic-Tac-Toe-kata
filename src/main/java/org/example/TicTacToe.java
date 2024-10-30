package org.example;

import java.util.List;

public class TicTacToe implements GameBoard {

    public TicTacToe(){}
    private List<String> board = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");

    @Override
    public void playIn(int position) {
        throw new ArrayIndexOutOfBoundsException("Last index is 9 !!");
    }

    @Override
    public String getBoard() {

        StringBuilder representation = new StringBuilder();
        for (int i = 0; i < board.size(); i++){
            if (i == board.size() - 1){
                representation.append(board.get(i));
            }else if ((i + 1) % 3 == 0) {
                representation.append(board.get(i)).append("\n----------\n");
            } else {
                representation.append(board.get(i)).append(" | ");
            }
        }

        return representation.toString();
    }
}
