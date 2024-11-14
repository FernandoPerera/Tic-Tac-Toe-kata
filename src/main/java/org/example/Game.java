package org.example;

import java.util.List;

public abstract class Game {

    protected final Board BOARD;
    protected final TurnManager TURN_MANAGER;
    private boolean gameIsOver = false;

    public Game(Board board, List<Player> players) {
        this.BOARD = board;
        this.TURN_MANAGER = new TurnManager(players);
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
