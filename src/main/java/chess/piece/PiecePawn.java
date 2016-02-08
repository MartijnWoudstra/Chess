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
<<<<<<< HEAD
    public boolean validMove(Board board, int toX, int toY) throws InvalidMoveException {
=======
    public boolean validMove(Board board, int toX, int toY) throws InvalidMoveException, OutOfBoardException {
        boolean ans;
>>>>>>> e20ff4bcb472016f42619ca43596267d459fd7fc
        super.validMove(board, toX, toY);
        boolean ans;
        /*
        Moving to a empty field. Checks if move is one forward.
         */
        if(board.isFieldEmpty(toX, toY)) {
<<<<<<< HEAD
            ans = Math.abs(Utils.index(toX - getX(), toY - getY())) == Board.DIM;
        }
        /*
        Hitting can be done in cross direction.
         */
        else {
            int index = Math.abs(Utils.index(toX - getX(), toY - getY()));
            ans = index == Board.DIM - 1 || index == Board.DIM + 1;
=======
            ans = Utils.index(toX - getX(), toY - getY()) == (getIsWhite() ? -1 * Board.DIM : Board.DIM);
        } else {

            int index = Utils.index(toX - getX(), toY - getY());
            int modifier = getIsWhite() ? - 1 : 1;
            ans = index == modifier * (Board.DIM - 1) || index == modifier * (Board.DIM + 1);
>>>>>>> e20ff4bcb472016f42619ca43596267d459fd7fc
        }
        return ans;
        //todo first move 2 places
    }
}
