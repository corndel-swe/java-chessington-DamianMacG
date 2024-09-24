package com.corndel.chessington.model.pieces;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

public class BishopTest {

    private Board board;
    private Bishop bishop = new Bishop(PlayerColour.WHITE);

    @BeforeEach
    public void setup() {
        board = Board.empty();
    }

    @Test
    public void bishopCanMoveDiagonally() {
        // Arrange
        Coordinates coords = new Coordinates(3, 4);
        board.placePiece(coords, bishop);

        // Act
        List<Move> allowedMoves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(allowedMoves)
                .containsExactlyInAnyOrder(
                        new Move(coords, new Coordinates(0, 1)),
                        new Move(coords, new Coordinates(1, 2)),
                        new Move(coords, new Coordinates(2, 3)),
                        new Move(coords, new Coordinates(4, 5)),
                        new Move(coords, new Coordinates(5, 6)),
                        new Move(coords, new Coordinates(6, 7)),
                        new Move(coords, new Coordinates(7, 0)),
                        new Move(coords, new Coordinates(6, 1)),
                        new Move(coords, new Coordinates(5, 2)),
                        new Move(coords, new Coordinates(4, 3)),
                        new Move(coords, new Coordinates(2, 5)),
                        new Move(coords, new Coordinates(1, 6)),
                        new Move(coords, new Coordinates(0, 7)));
    }

    @Test
    public void bishopCanCaptureOpposingPiece() {
        // Arrange
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);

        Piece opponent = new Queen(PlayerColour.BLACK);
        Coordinates opponentCoords = new Coordinates(2, 2);
        board.placePiece(opponentCoords, opponent);

        // Act
        List<Move> allowedMoves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(allowedMoves).contains(new Move(coords, opponentCoords));
    }

    @Test
    public void bishopCannotMoveThroughOpposingPiece() {
        // Arrange
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);

        Piece opponent = new Queen(PlayerColour.BLACK);
        Coordinates opponentCoords = new Coordinates(2, 2);
        board.placePiece(opponentCoords, opponent);

        // Act
        List<Move> allowedMoves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(allowedMoves)
                .doesNotContain(
                        new Move(coords, new Coordinates(1, 1)), new Move(coords, new Coordinates(0, 0)));
    }

    @Test
    public void bishopIsBlockedByFriendlyPiece() {
        // Arrange
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, bishop);

        Piece friendlyPiece = new Queen(PlayerColour.WHITE);
        Coordinates friendlyCoords = new Coordinates(2, 2);
        board.placePiece(friendlyCoords, friendlyPiece);

        // Act
        List<Move> allowedMoves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(allowedMoves)
                .doesNotContain(
                        new Move(coords, friendlyCoords),
                        new Move(coords, new Coordinates(1, 1)),
                        new Move(coords, new Coordinates(0, 0)));
    }
}
