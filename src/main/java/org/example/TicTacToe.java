package org.example;

import java.util.List;

public class TicTacToe extends Game {

    private final List<Player> PLAYERS;
    private Player nextPlayerToMove;

    public TicTacToe(Board board, List<Player> PLAYERS) {
        super(board);
        this.PLAYERS = PLAYERS;
        this.nextPlayerToMove = PLAYERS.get(0);
    }

    @Override
    protected void playIn(int position) {
        Board board = super.BOARD;

        board.occupyCell(position, nextPlayerToMove.getPiece());

        nextPlayerToMove = PLAYERS.get(
                PLAYERS.indexOf(nextPlayerToMove) == 0
                        ? 1
                        : 0
        );
    }

    @Override
    protected String getStatus() {
        return GameStates.PLAYING.name();
    }

}
