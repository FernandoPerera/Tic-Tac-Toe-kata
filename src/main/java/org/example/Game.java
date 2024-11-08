package org.example;

public abstract class Game {

    protected final Board BOARD;

    public Game(Board BOARD) {
        this.BOARD = BOARD;
    }

    protected abstract void playIn(int position);

    public String getBoard() {
        return Printer.display(BOARD.getCells());
    }
}
