package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Piece {

    private final Piece.PieceType type;
    protected final PlayerColour colour;

    public Pawn(PlayerColour colour) {
        this.type = PieceType.PAWN;
        this.colour = colour;
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        var allowedMoves = new ArrayList<Move>();
        boolean black = getColour().equals(PlayerColour.BLACK);
        boolean white = getColour().equals(PlayerColour.WHITE);

        if (white) {
            if (from.getRow() == 6) {
                allowedMoves.add(new Move(from, from.plus(-2, 0)));
            }
            if (board.get(from.plus(-1, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(-1, 0)));
            }

        }

        if (black) {
            if (from.getRow() == 1) {
                allowedMoves.add(new Move(from, from.plus(2, 0)));
            }
            if (board.get(from.plus(1, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(1, 0)));
            }
        }


        // TODO Implement this!
        return allowedMoves;
    }
}
