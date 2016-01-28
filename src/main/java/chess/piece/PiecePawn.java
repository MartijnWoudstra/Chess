package chess.piece;

import chess.board.Board;
import chess.exception.InvalidMoveException;
import chess.util.Utils;

/**
 * Created by martijn on 27-1-16.
 */
public class PiecePawn extends Piece {

    public PiecePawn(boolean isWhite, int x, int y) {
        super(isWhite, Type.PAWN, x, y);
    }

    @Override
    public boolean validMove(Board board, int toX, int toY) throws InvalidMoveException {
        boolean ans;
        super.validMove(board, toX, toY);
        if(board.isFieldEmpty(toX, toY)) {
            ans = Math.abs(Utils.index(toX - getX(), toY - getY())) == Board.DIM;
        } else {
            int index = Math.abs(Utils.index(toX - getX(), toY - getY()));
            ans = index == Board.DIM - 1 || index == Board.DIM + 1;
        }
        return ans;
    }
}
