package chess.board;

/**
 * Chess
 *
 * @author Martijn Woudstra
 * @version 1.0
 * @since 22-1-2016
 */
public class Start {
    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board.getField(1, 2).validMove(1, 2, 1, 3, board));
    }
}
