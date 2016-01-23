package chess.util;

import chess.board.Board;

/**
 * Created by martijn on 23-1-16.
 */
public class Utils {

    public static int index(int x, int y) {
        return y * Board.DIM + x;
    }
}
