package org.example;

public class Player {

    private String username;
    private Piece piece;

    public Player(String username, Piece piece) {
        this.username = username;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
