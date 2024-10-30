package org.example;

public class TicTacToe implements GameBoard {

    public TicTacToe(){}

    @Override
    public void playIn(int position) {
        throw new ArrayIndexOutOfBoundsException("Last index is 9 !!");
    }

    @Override
    public String getBoard() {
        throw new RuntimeException("Not implemented yet");
    }
}
