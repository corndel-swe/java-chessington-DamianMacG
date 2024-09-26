package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {

    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public String toString() {
        return getColour() + " " + getType();
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        List<Move> allowedMoves = new ArrayList<>();

        int[][] directions = {
                {2, 1},
                {2, -1},
                {-2, 1},
                {-2, -1},
                {1, 2},
                {1, -2},
                {-1, 2},
                {-1, -2}
        };

        for (int[] direction : directions) {
            int newRow = from.getRow() + direction[0];
            int newCol = from.getCol() + direction[1];

            if (newRow >= 0 && newRow < Board.BOARD_SIZE && newCol >= 0 && newCol < Board.BOARD_SIZE) {
                Coordinates newCoordinates = new Coordinates(newRow, newCol);
                Piece targetPiece = board.get(newCoordinates);

                if (targetPiece == null || targetPiece.getColour() != this.colour) {
                    allowedMoves.add(new Move(from, newCoordinates));
                }
            }
        }

        return allowedMoves;
    }
}

