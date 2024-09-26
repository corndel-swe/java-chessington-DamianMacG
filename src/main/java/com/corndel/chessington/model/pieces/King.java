package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class King extends AbstractPiece {

    public King(PlayerColour colour) {
        super(PieceType.KING, colour);
    }

    @Override
    public String toString() {
        return getColour() + " " + getType();
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();

        // Define possible moves with an array of arrays
        int[][] directions = {
                {1, 0},
                {1, 1},
                {0, 1},
                {-1, 1},
                {-1, 0},
                {-1, -1},
                {0, -1},
                {1, -1}
        };
        // Loop through the directions array and assign
        for (int[] direction : directions) {
            int newRow = from.getRow() + direction[0];
            int newCol = from.getCol() + direction[1];

            // Check that we are inside the board boundaries
            if (newRow >= 0 && newRow < Board.BOARD_SIZE && newCol >= 0 && newCol < Board.BOARD_SIZE) {

                Piece targetPiece = board.get(new Coordinates(newRow, newCol));
                if (targetPiece == null || targetPiece.getColour() != this.colour) {
                    allowedMoves.add(new Move(from, new Coordinates(newRow, newCol)));
                }
            }

        }

        return allowedMoves;
    }
}
