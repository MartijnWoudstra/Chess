package chess.board;

import chess.exception.EmptyFieldException;
import chess.exception.InvalidStartPosition;
import chess.piece.Color;
import chess.piece.Piece;
import chess.piece.Type;

import java.util.HashMap;
import java.util.Map;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public class Board {

    public static final int DIM = 8;
    public static final Piece NONE_PIECE = new Piece(Color.NONE, Type.NONE);

    Map<Integer, Piece> field;

    public Board() {
        field = new HashMap<Integer, Piece>();
        fillBoard();
        printBoard();
    }

    /**
     * Fills the board with {@link chess.piece.Piece}s.
     */
    private void fillBoard() {
        for (int x = 1; x < DIM + 1; x++) {
            for (int y = 1; y < DIM + 1; y++) {
                try {
                    setField(x, y, Piece.getPieceByStartingPosition(x, y));
                } catch (InvalidStartPosition invalidStartPosition) {
                    invalidStartPosition.printStackTrace();
                }
            }
        }
    }

    /**
     * Sets the field on the board to a specific {@link chess.piece.Piece}
     *
     * @param x     x-coordinate to place a {@link chess.piece.Piece}
     * @param y     y-coordinate to place a {@link chess.piece.Piece}
     * @param piece desired {@link chess.piece.Piece} to place
     */
    private void setField(int x, int y, Piece piece) {
        field.put(y * DIM + x, piece);
    }

    /**
     * Prints the board to the {@link System#out}
     */
    public void printBoard() {
        System.out.printf("   ");
        for (int i = 1; i < DIM + 1; i++) {
            System.out.printf("%d   ", i);
        }
        System.out.println();
        for (int y = 1; y < DIM + 1; y++) {
            System.out.printf("%d  ", y);
            for (int x = 1; x < DIM + 1; x++) {
                System.out.printf("%s%s  ", getField(x, y).getColor().toString(), getField(x, y).getType().toString());
            }
            System.out.printf("\n");
        }
    }

    /**
     * Returns a {@link chess.piece.Piece} on a specific (x, y) coordinate
     *
     * @param x x-coordinate to request {@link chess.piece.Piece}
     * @param y y-coordinate to request {@link chess.piece.Piece}
     * @return {@link chess.piece.Piece} at (x, y)
     */
    public Piece getField(int x, int y) {
        return field.get(y * DIM + x);
    }

    /**
     * Returns if a field is empty.
     * Does this by checking if the {@link chess.piece.Type} is equals to {@link chess.piece.Type#NONE}
     *
     * @param x x-coodinate you want to know whether is empty or not
     * @param y y-coodinate you want to know whether is empty or not
     * @return True if both {@link chess.piece.Type}s are equal, otherwise False.
     */
    public boolean isFieldEmpty(int x, int y){
        return getField(x, y).getType().equalsType(Type.NONE);
    }

    /**
     * Returns if a {@link chess.piece.Piece} has the same {@link chess.piece.Color} as a {@link chess.piece.Piece} at
     * (x, y)
     *
     * @param x x-coodinate you want to know whether is the same color or not
     * @param y y-coodinate you want to know whether is the same color or not
     * @param piece {@link chess.piece.Piece} you want to compare
     * @throws EmptyFieldException if the field you are checking is empty.
     * @return True if both {@link chess.piece.Piece}s have the same color, otherwise False.
     */
    public boolean isSameColor(int x, int y, Piece piece) throws EmptyFieldException {
        if(isFieldEmpty(x, y))
            throw new EmptyFieldException(x, y);
        else
            return piece.getColor().equalsColor(getField(x, y).getColor());
    }
}
