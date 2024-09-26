package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {


    public Pawn(PlayerColour colour) {
        super(PieceType.PAWN, colour);
    }

    @Override
    public String toString() {
        return getColour() + " " + getType();
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        var allowedMoves = new ArrayList<Move>();
        boolean black = getColour().equals(PlayerColour.BLACK);
        boolean white = getColour().equals(PlayerColour.WHITE);

        // For white pawns
        if (white) {
            if (from.getRow() == 6 && board.get(from.plus(-2, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(-2, 0))); // Double move
            }
            if (from.getRow() > 0 && board.get(from.plus(-1, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(-1, 0))); // Single move
            }
            // Capture diagonally
            if (from.getRow() > 0) {
                if (from.getCol() < 7 && board.get(from.plus(-1, 1)) != null &&
                        board.get(from.plus(-1, 1)).getColour() == PlayerColour.BLACK) {
                    allowedMoves.add(new Move(from, from.plus(-1, 1))); // Capture right
                }
                if (from.getCol() > 0 && board.get(from.plus(-1, -1)) != null &&
                        board.get(from.plus(-1, -1)).getColour() == PlayerColour.BLACK) {
                    allowedMoves.add(new Move(from, from.plus(-1, -1))); // Capture left
                }
            }
        }

        // For black pawns
        if (black) {
            if (from.getRow() == 1 && board.get(from.plus(2, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(2, 0))); // Double move
            }
            if (from.getRow() < 7 && board.get(from.plus(1, 0)) == null) {
                allowedMoves.add(new Move(from, from.plus(1, 0))); // Single move
            }
            // Capture diagonally
            if (from.getRow() < 7) {
                if (from.getCol() < 7 && board.get(from.plus(1, 1)) != null &&
                        board.get(from.plus(1, 1)).getColour() == PlayerColour.WHITE) {
                    allowedMoves.add(new Move(from, from.plus(1, 1))); // Capture right
                }
                if (from.getCol() > 0 && board.get(from.plus(1, -1)) != null &&
                        board.get(from.plus(1, -1)).getColour() == PlayerColour.WHITE) {
                    allowedMoves.add(new Move(from, from.plus(1, -1))); // Capture left
                }
            }
        }

        return allowedMoves;
    }
}
