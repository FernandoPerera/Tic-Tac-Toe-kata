package org.example;

public abstract class Game {

    protected final Board BOARD;
    private boolean gameIsOver = false;

    public Game(Board BOARD) {
        this.BOARD = BOARD;
    }

    protected abstract void playIn(int position);

    protected abstract String getStatus();

    protected String getBoard() {
        return Printer.display(BOARD.getCells());
    }

    protected void isOver() {
        this.gameIsOver = true;
    }

    protected boolean isGameOver() {
        return this.gameIsOver;
    }
}
