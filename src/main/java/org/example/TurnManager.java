package org.example;

import java.util.List;

public class TurnManager {
    private final List<Player> PLAYERS;
    private int currentPlayerIndex = 0;

    public TurnManager(List<Player> PLAYERS) {
        this.PLAYERS = PLAYERS;
    }

    public Player getCurrentPlayer() {
        return PLAYERS.get(currentPlayerIndex);
    }

    public void nextTurn() {
        currentPlayerIndex = currentPlayerIndex == PLAYERS.size() - 1
                ? 0
                : currentPlayerIndex + 1;
    }
}
