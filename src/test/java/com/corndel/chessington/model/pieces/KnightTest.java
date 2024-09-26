package com.corndel.chessington.model.pieces;

import static org.assertj.core.api.Assertions.assertThat;

import com.corndel.chessington.model.Board;
import com.corndel.chessington.model.Coordinates;
import com.corndel.chessington.model.Move;
import com.corndel.chessington.model.PlayerColour;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class KnightTest {

    private Board board;
    private Knight knight = new Knight(PlayerColour.WHITE);

    @BeforeEach
    public void setup() {
        board = Board.empty();
    }


    @Test
    public void knightsCanMoveLikeKnights() {
        // Arrange
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> allowedMoves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(allowedMoves)
                .containsExactlyInAnyOrder(
                        new Move(coords, new Coordinates(2, 3)),
                        new Move(coords, new Coordinates(2, 5)),
                        new Move(coords, new Coordinates(6, 3)),
                        new Move(coords, new Coordinates(6, 5)),
                        new Move(coords, new Coordinates(3, 6)),
                        new Move(coords, new Coordinates(5, 6)),
                        new Move(coords, new Coordinates(3, 2)),
                        new Move(coords, new Coordinates(5, 2)));
    }


    @Test
    public void knightsCannotLeaveBoard() {
        // Arrange
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, knight);

        // Act
        List<Move> allowedMoves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(allowedMoves)
                .containsExactlyInAnyOrder(
                        new Move(coords, new Coordinates(1, 2)), new Move(coords, new Coordinates(2, 1)));
    }


    @Test
    public void knightsCanCaptureOpposingPieces() {
        // Arrange
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, knight);

        Piece opponent = new Queen(PlayerColour.BLACK);
        Coordinates opponentCoords = new Coordinates(2, 1);
        board.placePiece(opponentCoords, opponent);

        // Act
        List<Move> allowedMoves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(allowedMoves).contains(new Move(coords, opponentCoords));
    }


    @Test
    public void knightsCannotLandOnFriendlyPieces() {
        // Arrange
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, knight);

        Piece friendlyPiece = new Queen(PlayerColour.WHITE);
        Coordinates friendlyCoords = new Coordinates(2, 1);
        board.placePiece(friendlyCoords, friendlyPiece);

        // Act
        List<Move> allowedMoves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(allowedMoves).doesNotContain(new Move(coords, friendlyCoords));
    }

    @Test
    public void knightCannotMoveOffBoard() {
        // Arrange
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates knightCoords = new Coordinates(0, 0);
        board.placePiece(knightCoords, knight);

        // Act
        List<Move> allowedMoves = knight.getAllowedMoves(knightCoords, board);

        // Assert
        // The knight at (0,0) can only move to (1,2) and (2,1)
        assertThat(allowedMoves).containsExactlyInAnyOrder(
                new Move(knightCoords, new Coordinates(1, 2)),
                new Move(knightCoords, new Coordinates(2, 1))
        );
    }
}
