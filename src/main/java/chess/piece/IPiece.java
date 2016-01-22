package chess.piece;

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
    public String getName();

    /**
     * Returns the {@link chess.piece.Type} of a {@link chess.piece.Piece}
     * @return      {@link chess.piece.Type} of a {@link chess.piece.Piece}
     */
    public Type getType();

    /**
     * Returns the {@link chess.piece.Color} of a {@link chess.piece.Piece}
     * @return       {@link chess.piece.Color} of a {@link chess.piece.Piece}
     */
    public Color getColor();
}
