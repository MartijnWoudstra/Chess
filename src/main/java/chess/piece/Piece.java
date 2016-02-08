package chess.piece;

import chess.board.Board;
import chess.exception.InvalidMoveException;
import chess.exception.InvalidStartPositionException;
import chess.exception.OutOfBoardException;
import chess.lib.ErrorLib;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public class Piece implements IPiece {

    /** {@link chess.piece.Type} of the current piece */
    private final Type type;
    /** this value is true if the piece is white, otherwise false */
    private final boolean isWhite;
    /** x-coordinate of the piece */
    private int x;
    /** y-coordinate of the piece */
    private int y;

    /**
     * Initialized a piece object, setting its {@link chess.piece.Type}. Also sets whether the color is white or not.
     *
     * @param isWhite whether the piece is white or not
     * @param type  {@link chess.piece.Type} object of the piece
     * @param x x-coordinate of the piece
     * @param y y-coordinate of the piece
     */
    public Piece(boolean isWhite, Type type, int x, int y) {
        this.isWhite = isWhite;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the {@link chess.piece.Piece} that belongs on the starting position of (x, y),
     * where {@code 1 < x < 8} and {@code 1 < y < 8}
     *
     * @param x an integer of the x coordinate on the board
     * @param y an integer of the Y coordinate on the board
     * @return {@link chess.piece.Piece} object that belong on (x, y)
     * @throws InvalidStartPositionException if {@code x > 8 || y > 8}
     */
    public static Piece getPieceByStartingPosition(int x, int y) throws InvalidStartPositionException {
        if (x > 8 || y > 8)
            throw new InvalidStartPositionException(x, y);
        if (y == 2)
            return new PiecePawn(false, x, y);
        else if (y == 7)
            return new PiecePawn(true, x, y);
        else if (y == 1 || y == 8) {
            boolean boolIsWhite = y != 1;
            switch (x) {
                case 1:
                case 8:
                    return new PieceRook(boolIsWhite, x, y);
                case 2:
                case 7:
                    return new PieceHorse(boolIsWhite, x, y);
                case 3:
                case 6:
                    return new PieceBishop(boolIsWhite, x, y);
                case 4:
                    return new PieceQueen(boolIsWhite, x, y);
                case 5:
                    return new PieceKing(boolIsWhite, x, y);
            }
        }
        return null;
    }

    /**
     * Returns the x-coordinate of a piece
     *
     * @return x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of a piece
     *
     * @param x x-coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y-coordinate of a piece
     *
     * @return y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of a piece
     *
     * @param y y-coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getName() {
        return (isWhite ? PieceLib.NAME_WHITE : PieceLib.NAME_BLACK) + type.getName();
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public boolean getIsWhite() {
        return isWhite;
    }

    @Override
<<<<<<< HEAD
    public boolean validMove(Board board, int toX, int toY) throws InvalidMoveException{
        /* same location*/
        if(toX == x && toY == y){
            throw new InvalidMoveException(toX, toY, ErrorLib.SAME_LOCATION);
        }
        /* out of board*/
        else if (toX < 1 || toX > Board.DIM || toY < 1 || toY > Board.DIM) {
            throw new InvalidMoveException(toX, toY, ErrorLib.OUTSIDE_FIELD);
        }
        /* already occupied by same color*/
        else if (!board.isFieldEmpty(toX, toY) && board.getPiece(toX, toY).isWhite && isWhite){
            throw new InvalidMoveException(toX, toY, ErrorLib.SAME_COLOR);
        }
        /* hitting the king is not allowed.*/
        else if (board.getPiece(toX, toY)  != null){
=======
    public boolean validMove(Board board, int toX, int toY) throws InvalidMoveException, OutOfBoardException {
        if(toX == x && toY == y){
            throw new InvalidMoveException(getX(), getY(), toX, toY, ErrorLib.SAME_LOCATION);
        } else if (toX < 1 || toX > Board.DIM || toY < 1 || toY > Board.DIM) {
            throw new OutOfBoardException(toX, toY);
        } else if (!board.isFieldEmpty(toX, toY) && (board.getPiece(toX, toY).isWhite == isWhite)){
            throw new InvalidMoveException(getX(), getY(), toX, toY, ErrorLib.SAME_COLOR);
        } else if (board.getPiece(toX, toY)  != null){
>>>>>>> e20ff4bcb472016f42619ca43596267d459fd7fc
                if(board.getPiece(toX, toY).getType().equalsType(Type.KING)) {
                    throw new InvalidMoveException(getX(), getY(), toX, toY, ErrorLib.HIT_KING);
                }
        }
        return true;
    }
}
