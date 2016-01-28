package chess.board;

import chess.piece.Piece;

/**
 * Created by martijn on 27-1-16.
 */
public class Spot {

    /** {@link chess.piece.Piece} on the this spot */
    private Piece piece;

    /**
     * Returns the {@link chess.piece.Piece} object
     * @return {@link chess.piece.Piece} object
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Sets the {@link chess.piece.Piece} of this instance
     *
     * @param piece {@link chess.piece.Piece} object
     */
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    /**
     * Returns if the field is empty.
     * Checked by comparing instance variable for piece with null
     *
     * @return true if {@link chess.board.Spot} is empty, otherwise false
     */
    public boolean isEmpty() {
        return piece == null;
    }

    /**
     * Sets the {@link chess.board.Spot} to empty
     * Does this by setting the instance variable for {@link chess.piece.Piece} to null
     */
    public void setEmptyPiece(){
        piece = null;
    }
}
