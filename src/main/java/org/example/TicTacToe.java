package org.example;

public class TicTacToe implements GameBoard {

    public TicTacToe(){}

    @Override
    public void playIn(int position) {
        throw new ArrayIndexOutOfBoundsException("Last index is 9 !!");
    }

    @Override
    public String getBoard() {
        return "1|2|3\n" + "------\n" +
                "4|5|6\n" + "------\n"+
                "7|8|9\n" + "------\n";
    }
}
