package chess.piece;

import chess.board.Board;

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
     * @return      String representation of the {@link chess.piece.Piece}
     */
    String getName();

    /**
     * Returns the {@link chess.piece.Type} of a {@link chess.piece.Piece}
     * @return      {@link chess.piece.Type} of a {@link chess.piece.Piece}
     */
    Type getType();

    /**
     * Returns the {@link chess.piece.Color} of a {@link chess.piece.Piece}
     * @return       {@link chess.piece.Color} of a {@link chess.piece.Piece}
     */
    Color getColor();

    int[] getNormalMoves();

    int[] getHitMoves();

    boolean validMove(int x, int y, int dx, int dy, Board board);
}
