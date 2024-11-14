package org.example;

import java.util.List;

public class TicTacToe extends Game {

    private final TurnManager TURN_MANAGER;
    private final TicTacToeWinChecker WIN_CHECKER;
    private boolean isGameOver = false;

    public TicTacToe(Board board, List<Player> players) {
        super(board);
        this.WIN_CHECKER = new TicTacToeWinChecker();
        this.TURN_MANAGER = new TurnManager(players);
    }

    @Override
    protected void playIn(int position) {
        if (isGameOver) return;

        makeMove(position);
        checkGameStatus();
    }

    @Override
    public String getStatus() {
        List<String> boardCells = BOARD.getCells();

        return WIN_CHECKER.findWinner(boardCells)
                .orElseGet(() -> determineGameState(boardCells));
    }

    private void makeMove(int position) {
        Player currentPlayer = TURN_MANAGER.getCurrentPlayer();
        BOARD.occupyCell(position, currentPlayer.getPiece());
        TURN_MANAGER.nextTurn();
    }

    private void checkGameStatus() {
        WIN_CHECKER.findWinner(BOARD.getCells()).ifPresent(
                winner -> isGameOver = true
        );
    }

    private String determineGameState(List<String> boardCells) {
        return WIN_CHECKER.isGameStuck(boardCells)
                ? GameStates.STUCK.name()
                : GameStates.PLAYING.name();
    }

}
