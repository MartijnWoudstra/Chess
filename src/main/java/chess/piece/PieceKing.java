package chess.piece;

import chess.board.Board;
import chess.board.Movement;
import chess.exception.InvalidMoveException;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public class PieceKing extends Piece {

    public PieceKing(boolean isWhite, int x, int y) {
        super(isWhite, Type.KING, x, y);
    }

    @Override
    public boolean validMove(Board board, int toX, int toY) throws InvalidMoveException {
        super.validMove(board, toX, toY);
        return Movement.leftRight(this, toX, toY) || Movement.oneForward(this, toX, toY) ||
                Movement.oneBackward(this, toX, toY);
        //todo chess sets
        //todo swap rook
    }
}
