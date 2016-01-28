package chess.piece;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public class PieceQueen extends Piece {

    public PieceQueen(boolean isWhite, int x, int y) {
        super(isWhite, Type.QUEEN, x, y);
    }
}
