package chess.board;

import chess.exception.InvalidMoveException;
import chess.piece.Piece;
import chess.util.Utils;

/**
 * Created by martijn on 3-2-16.
 */

/**
 * Helper class for
 */
public class Movement {

    public static boolean oneForward(Piece piece, int x, int y){
        int index = getIndex(piece, x, y);
        return piece.getIsWhite() ? index == - Board.DIM : index == Board.DIM;
    }

    public static boolean Forward(Piece piece, int x, int y){
        int index = getIndex(piece, x, y);
        return piece.getIsWhite() ? index < 0 : index > 0;
    }

    public static boolean oneBackward(Piece piece, int x, int y){
        int index = getIndex(piece, x, y);
        return piece.getIsWhite() ? index == Board.DIM : index == - Board.DIM;
    }

    public static boolean backward(Piece piece, int x, int y) {
        int index = getIndex(piece, x, y);
        return piece.getIsWhite() ? index > 0 : index < 0;
    }

    public static boolean leftRight(Piece piece, int x, int y){
        int index = getIndex(piece, x, y);
        return index == 1 || index == - 1;
    }

    private static int getIndex(Piece piece, int x, int y) {
        return Utils.index(x - piece.getX(), y - piece.getY());
    }

    public static int getOneForward(Piece piece){
        return piece.getIsWhite() ? Utils.index(piece.getX(), piece.getY()) - Board.DIM : Utils.index(piece.getX(), piece.getY()) + Board.DIM;
    }

    public static int getOneBackward(Piece piece){
        return piece.getIsWhite() ? Utils.index(piece.getX(), piece.getY()) + Board.DIM : Utils.index(piece.getX(), piece.getY()) -Board.DIM;
    }

    public static boolean isHorseMove(Piece piece, int x, int y){
        int index = Math.abs(Utils.index(piece.getX() - x, piece.getY() - y));
        return Math.abs(index) == 2*Board.DIM + 1 || Math.abs(index) == 2*Board.DIM - 1 ||
                Math.abs(index) == Board.DIM + 2 || Math.abs(index) == Board.DIM - 2;
    }

    public static boolean hasPieceOnItsWay(Piece piece, int toX, int toY){
        boolean white = piece.getIsWhite();
        int x = piece.getX();
        int y = piece.getY();
        return false;
    }

    public static boolean isDiagonal(Piece piece, int x, int y) throws InvalidMoveException{
        boolean ans = false;
        int index = getIndex(piece, x, y);
        if(x < piece.getX() && y < piece.getY())
            for (int i = 0; !ans & i < Board.DIM; i++) {
                ans = (- (Board.DIM * i) - i) == index;
            }
        else if(x > piece.getX() && y < piece.getY())
            for (int i = 0; !ans & i < Board.DIM; i++) {
                ans = (- (Board.DIM * i) + i) == index;
            }
        else if(x < piece.getX() && y > piece.getY())
            for (int i = 0; !ans & i < Board.DIM; i++) {
                ans = ((Board.DIM * i) - i) == index;
            }
        else if(x > piece.getX() && y > piece.getY())
            for (int i = 0; !ans & i < Board.DIM; i++) {
                ans = ((Board.DIM * i) + i) == index;
            }
        else {
            return piece.getX() == x && piece.getY() == y;
        }
        return ans;
    }

    public static boolean isHorizontalOrVertical(Piece piece, int x, int y){
        boolean ans = false;
        if(x == piece.getX())
            for (int i = 0; i < Board.DIM; i++) {
                if (Board.DIM * i == Utils.index(x - piece.getX(), Math.abs(y - piece.getY())))
                    ans = true;
            }
        else if(y == piece.getY())
            for (int i = 0; i < Board.DIM; i++) {
                if(i == Math.abs(x - piece.getX()))
                    ans = true;
            }
        else {
            return false;
        }
        return ans;
    }
}
