package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.PlayerColour;

public abstract class AbstractPiece implements Piece {

    private final PieceType type;
    protected final PlayerColour colour;

    protected AbstractPiece(PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
    }

    @Override
    public PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }
}
