package chess.piece;

import chess.board.Board;
import chess.exception.InvalidMoveException;
import chess.exception.OutOfBoardException;
import chess.util.Utils;

/**
 * Created by martijn on 27-1-16.
 */
public class PiecePawn extends Piece {

    public PiecePawn(boolean isWhite, int x, int y) {
        super(isWhite, Type.PAWN, x, y);
    }

    @Override
    public boolean validMove(Board board, int toX, int toY) throws InvalidMoveException, OutOfBoardException {
        boolean ans;
        super.validMove(board, toX, toY);
        if(board.isFieldEmpty(toX, toY)) {
            ans = Utils.index(toX - getX(), toY - getY()) == (getIsWhite() ? -1 * Board.DIM : Board.DIM);
        } else {

            int index = Utils.index(toX - getX(), toY - getY());
            int modifier = getIsWhite() ? - 1 : 1;
            ans = index == modifier * (Board.DIM - 1) || index == modifier * (Board.DIM + 1);
        }
        return ans;
    }
}
