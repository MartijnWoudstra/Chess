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
public class PieceHorse extends Piece {

    public PieceHorse(boolean isWhite, int x, int y) {
        super(isWhite, Type.HORSE, x, y);
    }

    @Override
    public boolean validMove(Board board, int toX, int toY) throws InvalidMoveException {
        super.validMove(board, toX, toY);
        /* true if move is horse move, other scenario's are caught in super method */
        return Movement.isHorseMove(this, toX, toY);
    }
}
