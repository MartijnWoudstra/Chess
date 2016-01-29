package chess.piece;

import chess.board.Board;
import chess.exception.InvalidMoveException;
import chess.exception.OutOfBoardException;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public interface IPiece {

    /**
     * Returns the name of a {@link chess.piece.Piece}
     *
     * @return      String representation of the {@link chess.piece.Piece}
     */
    String getName();

    /**
     * Returns the {@link chess.piece.Type} of a {@link chess.piece.Piece}
     *
     * @return      {@link chess.piece.Type} of a {@link chess.piece.Piece}
     */
    Type getType();

    /**
     * Returns if the piece is white or not
     *
     * @return true if piece is white, otherwise false
     */
    boolean getIsWhite();

    /**
     * Calculates if a move is valid or not
     *
     * @param board {@link chess.board.Board} object where the move is placed on
     * @param toX x-coordinate you want to move to
     * @param toY y-coordinate you want to move to
     * @return true if move is valid, otherwise false
     * @throws InvalidMoveException thrown if move is invalid.
     */
    boolean validMove(Board board, int toX, int toY) throws InvalidMoveException, OutOfBoardException;
}
