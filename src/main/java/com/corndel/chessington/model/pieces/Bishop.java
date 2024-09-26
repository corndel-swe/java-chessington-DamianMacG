package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {

    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public String toString() {
        return getColour() + " " + getType();
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();

        int[][] directions = {
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1}
        };

        // Loop through each diagonal direction
        for (int[] direction : directions) {
            int rowOffset = direction[0];
            int colOffset = direction[1];

            int newRow = from.getRow() + rowOffset;
            int newCol = from.getCol() + colOffset;

            // Keep moving in the current direction until you hit the edge of the board or a piece
            // If the square is empty the bishop can keep moving until it hits a piece or the board edge
            while (newRow >= 0 && newRow < Board.BOARD_SIZE && newCol >= 0 && newCol < Board.BOARD_SIZE) {
                Piece targetPiece = board.get(new Coordinates(newRow, newCol));

                if (targetPiece == null) {
                    allowedMoves.add(new Move(from, new Coordinates(newRow, newCol)));
                } else if (targetPiece.getColour() != this.colour) {
                    allowedMoves.add(new Move(from, new Coordinates(newRow, newCol)));
                    break;
                }
                // If there is a piece of the same color - stop
                else {
                    break;
                }

                // Continue moving in the same diagonal direction by updating coordinates
                newRow += rowOffset;
                newCol += colOffset;
            }
        }

        return allowedMoves;
    }
}
