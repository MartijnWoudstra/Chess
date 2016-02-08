package chess.util;

import chess.board.Board;

/**
 * Created by martijn on 23-1-16.
 */
public class Utils {

    /**
     * Returns the index on the board of a given (x, y)
     * 0 <= result < (Board.DIM * Board.DIM)
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @return Integer representation of the index on the board
     */
    public static int index(int x, int y) {
        return y * Board.DIM + x;
    }
}
