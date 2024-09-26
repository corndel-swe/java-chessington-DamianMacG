package com.corndel.chessington.model.pieces;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Piece {

    private final Piece.PieceType type;
    protected final PlayerColour colour;

    public Knight(PlayerColour colour) {
        this.type = PieceType.KNIGHT;
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

