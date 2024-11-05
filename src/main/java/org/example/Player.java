package org.example;

public class Player {

    private final String USERNAME;
    private final Piece PIECE;

    public Player(String username, Piece piece) {
        this.USERNAME = username;
        this.PIECE = piece;
    }

    public Piece getPiece() {
        return PIECE;
    }
}
